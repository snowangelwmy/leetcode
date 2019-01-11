/**
 * Test cases:
 * 1: Input:
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * Output: 3
 * Explanation: The paths that sum to 8 are:
 *  1. 5 -> 3
 *  2. 5 -> 2 -> 1
 *  3. -3 -> 11
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q437 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int pathSum(TreeNode root, int sum) {
    int count = 0;
    if(root==null){
      return count;
    }
    count += pathSumStartingFrom(root, sum);
    count += pathSum(root.left, sum);
    count += pathSum(root.right, sum);
    return count;
  }

  private int pathSumStartingFrom(TreeNode root, int sum){
    int count = 0;
    if(root.val==sum){
      count++;
    }
    if(root.left!=null){
      count += pathSumStartingFrom(root.left, sum-root.val);
    }
    if(root.right!=null){
      count += pathSumStartingFrom(root.right, sum-root.val);
    }
    return count;
  }
}