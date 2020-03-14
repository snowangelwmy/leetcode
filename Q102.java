/**
 * Test cases:
 * 1: Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
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
import java.util.Queue;
import java.util.LinkedList;

class Q102 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root==null) {
      return result;
    }

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while(!nodes.isEmpty()) {
      List<Integer> nums = new ArrayList<>();
      Queue<TreeNode> childrenNodes = new LinkedList<>();
      while(!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        nums.add(node.val);
        if(node.left!=null) {
          childrenNodes.offer(node.left);
        }
        if(node.right!=null) {
          childrenNodes.offer(node.right);
        }
      }
      result.add(nums);
      nodes = childrenNodes;
    }

    return result;
  }
}