/**
 * Test cases:
 * 1: Input & Output:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * 2: Input & Output:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Q572 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if(isSame(s, t)) {
      return true;
    }

    boolean isSubtree = false;
    if(s.left!=null) {
      isSubtree = isSubtree(s.left, t);
    }
    if(isSubtree) {
      return true;
    }

    if(s.right!=null) {
      isSubtree = isSubtree(s.right, t);
    }
    return isSubtree;
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if(s.val!=t.val) {
      return false;
    }
    if(s.left!=t.left&&(s.left==null||t.left==null)) {
      return false;
    }
    boolean isSame = true;
    if(s.left!=null&&t.left!=null) {
      isSame = isSame(s.left, t.left);
    }
    if(!isSame) {
      return false;
    }
    if(s.right!=t.right&&(s.right==null||t.right==null)) {
      return false;
    }
    if(s.right==null&&t.right==null) {
      return true;
    }
    isSame = isSame(s.right, t.right);
    return isSame;
  }
}