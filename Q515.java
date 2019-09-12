/**
 * Test cases:
 * 1: Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Q515 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root==null) {
      return result;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while(!nodes.isEmpty()) {
      Queue<TreeNode> children = new LinkedList<>();
      int largest = nodes.peek().val;
      while(!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        if(node.val>largest) {
          largest = node.val;
        }
        if(node.left!=null) {
          children.offer(node.left);
        }
        if(node.right!=null) {
          children.offer(node.right);
        }
      }
      result.add(largest);
      nodes = children;
    }
    return result;
  }
}