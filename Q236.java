/**
 * Test cases:
 * 1: Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *       3
 *    /    \
 *   5     1
 *  / \   / \
 * 6  2  0  8
 *   / \
 *  7  4
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 2: Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *       3
 *    /    \
 *   5     1
 *  / \   / \
 * 6  2  0  8
 *   / \
 *  7  4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Q236 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class ResultNode {
    TreeNode node;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ResultNode result = new ResultNode();
    this.lowestCommonAncestorHelper(root, p, q, result);
    return result.node;
  }

  private boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q, ResultNode result) {
    if(root==null) {
      return false;
    }
    int midFound = 0;
    if(root==p||root==q) {
      midFound = 1;
    }
    int leftFound = this.lowestCommonAncestorHelper(root.left, p, q, result) ? 1: 0;
    int rightFound = this.lowestCommonAncestorHelper(root.right, p, q, result) ? 1: 0;
    if(midFound + leftFound + rightFound >=2) {
      result.node = root;
    }
    return (midFound + leftFound + rightFound>0) ? true : false;
  }
}