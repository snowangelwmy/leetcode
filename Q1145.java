/**
 * Test cases:
 * 1: Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 *               1
 *           /     \
 *         2        3
 *       /   \     /  \
 *     4      5   6    7
 *    / \    / |
 *   8  9  10  11
 * Output: true
 * Explanation: The second player can choose the node with value 2.
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
class Q1145 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  //https://leetcode.com/problems/binary-tree-coloring-game/discuss/380135/Java.-100-faster.-Easy-to-understand
  //https://leetcode.com/problems/binary-tree-coloring-game/discuss/448494/Java-(100-100)
  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    if(root==null) return false;

    TreeNode xNode = findNode(root, x);
    if(xNode==null) return true;

    int leftCount = countChildren(xNode.left);
    int rightCount = countChildren(xNode.right);
    int parentCount = n - leftCount - rightCount - 1;
    // after first player choose, the second player can have 3 options: choose parent, left or right so that he can block the frist player from choosing the subtree of the node that second player choose
    return parentCount > (leftCount + rightCount + 1) || leftCount > (n - leftCount) || rightCount > (n - rightCount);
  }

  private TreeNode findNode(TreeNode root, int x) {
    if(root==null || root.val == x) {
      return root;
    }

    TreeNode found = findNode(root.left, x);
    if(found != null) {
      return found;
    }

    return findNode(root.right, x);
  }

  private int countChildren(TreeNode root) {
    if(root==null) {
      return 0;
    }

    return 1 + countChildren(root.left) + countChildren(root.right);
  }
}