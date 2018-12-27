/**
 * Test cases:
 * 1: Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    int sum = 0;
    if(root==null){
      return sum;
    }
    if(root.left!=null){
      if(isLeaf(root.left)) {
        sum += root.left.val;
      } else {
        sum += sumOfLeftLeaves(root.left);
      }
    }
    if(root.right!=null){
      if(!isLeaf(root.right)) {
        sum += sumOfLeftLeaves(root.right);
      }
    }

    return sum;
  }

  private boolean isLeaf(TreeNode node) {
    return node.left==null&&node.right==null;
  }
}