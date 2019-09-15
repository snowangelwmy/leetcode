/**
 * Test cases:
 * 1: Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * 2: Input:
 *        2147483647
 *        /        \
 *  2147483647   2147483647
 * Output: [2147483647, 2147483647]
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

class Q637 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if(root==null) {
      return result;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while(!nodes.isEmpty()) {
      double sum = 0;
      int count = 0;
      Queue<TreeNode> children = new LinkedList<>();
      while(!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        sum += node.val;
        count++;
        if(node.left!=null) {
          children.offer(node.left);
        }
        if(node.right!=null) {
          children.offer(node.right);
        }
      }
      if(count>0) {
        result.add(sum/count);
      }
      nodes = children;
    }
    return result;
  }
}