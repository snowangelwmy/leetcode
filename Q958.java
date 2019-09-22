/**
 * Test cases:
 * 1: Input: [1,2,3,4,5,6]
 *           1
 *         /   \
 *        2     3
 *      /  \   /
 *     4   5  6
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * 2: Input: [1,2,3,4,5,null,7]
 *           1
 *         /   \
 *        2     3
 *      /  \     \
 *     4   5     7
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
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

class Q958 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean isCompleteTree(TreeNode root) {
    if(root==null) {
      return true;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    boolean missing = false;
    while(!nodes.isEmpty()) {
      Queue<TreeNode> children = new LinkedList<>();
      while(!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        if(node.left!=null) {
          children.offer(node.left);
          if(missing) {
            return false;
          }
        } else {
          missing = true;
        }
        if(node.right!=null) {
          children.offer(node.right);
          if(missing) {
            return false;
          }
        } else {
          missing = true;
        }
      }
      nodes = children;
    }
    return true;
  }
}