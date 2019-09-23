/**
 * Test cases:
 * 1: Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 *           8
 *         /   \
 *        3    10
 *      /  \    \
 *     1   6    14
 *        / \   /
 *       4  7  13
 * Output: 7
 * Explanation:
 * We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
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
import java.util.Collections;

class Q1026 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class MaxDiff {
    int value;

    MaxDiff(int value) {
      this.value = value;
    }
  }

  //Approach 2: Not use extra space and run time is shorter
  public int maxAncestorDiff(TreeNode root) {
    if(root==null) {
      return 0;
    }
    MaxDiff maxDiff = new MaxDiff(0);
    dfs(root, root.val, root.val, maxDiff);
    return maxDiff.value;
  }

  private void dfs(TreeNode root, int max, int min, MaxDiff maxDiff) {
    int newMax = Math.max(root.val, max);
    int newMin = Math.min(root.val, min);
    maxDiff.value = Math.max(maxDiff.value, newMax-newMin);
    if(root.left!=null) {
      dfs(root.left, newMax, newMin, maxDiff);
    }
    if(root.right!=null) {
      dfs(root.right, newMax, newMin, maxDiff);
    }
  }

  //Approach 1: Use extra space and run time is longer
  public int maxAncestorDiff0(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    MaxDiff maxDiff = new MaxDiff(0);
    dfs(root, values, maxDiff);
    return maxDiff.value;
  }

  private void dfs(TreeNode root, List<Integer> values, MaxDiff maxDiff) {
    if(root==null) {
      return;
    }
    if(root.left==null&&root.right==null) {
      values.add(root.val);
      int localMaxDiff = findMaxDiff(values);
      maxDiff.value = Math.max(maxDiff.value, localMaxDiff);
      values.remove(values.size()-1);
      return;
    }
    if(root.left!=null) {
      values.add(root.val);
      dfs(root.left, values, maxDiff);
      values.remove(values.size()-1);
    }
    if(root.right!=null) {
      values.add(root.val);
      dfs(root.right, values, maxDiff);
      values.remove(values.size()-1);
    }
  }

  private int findMaxDiff(List<Integer> values) {
    if(values.size()<2) {
      return 0;
    }
    List<Integer> copy = new ArrayList<>(values);
    Collections.sort(copy);
    return copy.get(copy.size()-1)-copy.get(0);
  }
}