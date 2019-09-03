/**
 * Test cases:
 * 1: Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 2: Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
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
import java.lang.StringBuilder;

class Q129 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class Sum {
    int val;

    Sum(int val) {
      this.val = val;
    }
  }

  // Avoid using extra space to store paths
  public int sumNumbers(TreeNode root) {
    if(root==null) {
      return 0;
    }
    Sum sum = new Sum(0);
    sumNumbersHelper(root, sum, 0);
    return sum.val;
  }

  private void sumNumbersHelper(TreeNode root, Sum sum, int temp) {
    temp = 10*temp + root.val;
    if(root.left==null && root.right==null) {
      sum.val += temp;
      return;
    }

    if(root.left!=null) {
      this.sumNumbersHelper(root.left, sum, temp);
    }

    if(root.right!=null) {
      this.sumNumbersHelper(root.right, sum, temp);
    }
  }

  // Using extra space to store all paths
  public int sumNumbers0(TreeNode root) {
    if(root==null) {
      return 0;
    }
    List<Integer> nums = new ArrayList<>();
    getAllNums(root, nums, new StringBuilder());
    int sum = 0;
    for(Integer num : nums) {
      System.out.println(num);
      sum += num;
    }
    return sum;
  }

  private void getAllNums(TreeNode root, List<Integer> nums, StringBuilder num) {
    num.append(root.val);
    if(root.left==null && root.right==null) {
      nums.add(Integer.parseInt(new StringBuilder(num).toString()));
      num.deleteCharAt(num.length()-1);
      return;
    }

    if(root.left!=null) {
      this.getAllNums(root.left, nums, num);
    }
    if(root.right!=null) {
      this.getAllNums(root.right, nums, num);
    }
    num.deleteCharAt(num.length()-1);
  }
}