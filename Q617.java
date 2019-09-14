/**
 * Test cases:
 * 1: Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Q617 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if(t1==null&&t2==null) {
      return null;
    }
    if(t1==null) {
      return t2;
    }
    if(t2==null) {
      return t1;
    }
    //t1!=null&&t2!=null
    int val = t1.val + t2.val;
    TreeNode root = new TreeNode(val);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;
  }
}