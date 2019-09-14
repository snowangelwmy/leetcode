/**
 * Test cases:
 * 1: Input:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Output: Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Q543 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class Diameter {
    int length;

    Diameter(int length) {
      this.length = length;
    }
  }

  public int diameterOfBinaryTree(TreeNode root) {
    Diameter diameter = new Diameter(0);
    depth(root, diameter);
    return diameter.length;
  }

  private int depth(TreeNode root, Diameter diameter) {
    if(root==null) {
      return 0;
    }
    int leftDepth = depth(root.left, diameter);
    int rightDepth = depth(root.right, diameter);
    diameter.length = Math.max(leftDepth+rightDepth, diameter.length);
    return Math.max(leftDepth, rightDepth)+1;
  }
}