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
 *   [20,9],
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
import java.util.LinkedList;

class Q103 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root==null) {
      return result;
    }

    int direction = 1;
    LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while(!nodes.isEmpty()) {
      List<Integer> nums = new ArrayList<>();
      LinkedList<TreeNode> childrenNodes = new LinkedList<>();
      if(direction==1) {
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
      } else {//direction==-1
        while(!nodes.isEmpty()) {
          TreeNode node = nodes.pollLast();
          nums.add(node.val);
          if(node.right!=null) {
            childrenNodes.add(0, node.right);
          }
          if(node.left!=null) {
            childrenNodes.add(0, node.left);
          }
        }
      }
      if(nums.size()>0) {
        result.add(nums);
      }
      nodes = childrenNodes;
      direction *= -1;
    }
    return result;
  }
}  