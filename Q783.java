/**
 * Test cases:
 * 1: Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
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

class Q783 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int minDiffInBST(TreeNode root) {
    if(root==null) {
      return 0;
    }
    List<Integer> values = new ArrayList<>();
    inorderTraversal(root, values);
    int minDiff = Integer.MAX_VALUE;
    for(int i=1; i<values.size(); i++) {
      if(values.get(i)-values.get(i-1)<minDiff) {
        minDiff = values.get(i)-values.get(i-1);
      }
    }
    return minDiff;
  }

  private void inorderTraversal(TreeNode root, List<Integer> values) {
    if(root.left==null&&root.right==null) {
      values.add(root.val);
      return;
    }
    if(root.left!=null) {
      inorderTraversal(root.left, values);
    }
    values.add(root.val);
    if(root.right!=null) {
      inorderTraversal(root.right, values);
    }
  }
}