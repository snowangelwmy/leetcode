/**
 * Test cases:
 * 1: Input:
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Output:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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

import java.util.List;
import java.util.ArrayList;

class Q113 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if(root==null) {
      return result;
    }

    List<Integer> nums = new ArrayList<>();
    pathSumHelper(root, sum, result, nums, 0);
    return result;
  }

  private void pathSumHelper(TreeNode root, int target, List<List<Integer>> result, List<Integer> nums, int sum) {
    nums.add(root.val);
    sum += root.val;
    if(root.left==null && root.right==null) {
      if(sum==target) {
        result.add(new ArrayList<Integer>(nums));
        nums.remove(nums.size()-1);
        return;
      } else {//sum!=target
        nums.remove(nums.size()-1);
        return;
      }
    }

    //root.left!=null || root.right!=null
    if(root.left!=null) {
      this.pathSumHelper(root.left, target, result, nums, sum);
    }

    if(root.right!=null) {
      this.pathSumHelper(root.right, target, result, nums, sum);
    }
    nums.remove(nums.size()-1);
  }
}