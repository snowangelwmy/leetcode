/**
 * Test cases:
 * 1: Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *       \
 *        1
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q654 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if(nums==null||nums.length==0) {
      return null;
    }

    return constructMaximumBinaryTreeHelper(nums, 0, nums.length-1);
  }

  private TreeNode constructMaximumBinaryTreeHelper(int[] nums, int start, int end) {
    if(start>end) {
      return null;
    }
    if(start==end) {
      return new TreeNode(nums[start]);
    }
    //start<end
    int maxi_index = getMaxinumIndex(nums, start, end);
    TreeNode root = new TreeNode(nums[maxi_index]);
    root.left = constructMaximumBinaryTreeHelper(nums, start, maxi_index-1);
    root.right = constructMaximumBinaryTreeHelper(nums, maxi_index+1, end);
    return root;
  }

  private int getMaxinumIndex(int[] nums, int start, int end) {
    int maxi_num = nums[start];
    int maxi_index = start;
    for(int i=start; i<=end; i++) {
      if(nums[i]>maxi_num) {
        maxi_num = nums[i];
        maxi_index = i;
      }
    }

    return maxi_index;
  }
}
