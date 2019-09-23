/**
 * Test cases:
 * 1: Input: root = [1,2,3,4], x = 4, y = 3
 *           1
 *         /   \
 *        2     3
 *      /
 *     4
 * Output: false
 * 2: Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 *           1
 *         /   \
 *        2     3
 *        \      \
 *         4      5
 * Output: true
 * 3: root = [1,2,3,null,4], x = 2, y = 3
 *           1
 *         /   \
 *        2     3
 *        \
 *         4
 * Output: false
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

class Q993 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean isCousins(TreeNode root, int x, int y) {
    if(root==null) {
      return false;
    }

    if(root.val==x||root.val==y) {
      return false;
    }

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while(!nodes.isEmpty()) {
      boolean findX = false;
      boolean findY = false;
      TreeNode xParent = null;
      TreeNode yParent = null;
      Queue<TreeNode> children = new LinkedList<>();
      while(!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        if(node.left!=null) {
          children.offer(node.left);
          if(node.left.val==x) {
            findX = true;
            xParent = node;
          } else if(node.left.val==y) {
            findY = true;
            yParent = node;
          }
        }
        if(node.right!=null) {
          children.offer(node.right);
          if(node.right.val==x) {
            findX = true;
            xParent = node;
          } else if(node.right.val==y) {
            findY = true;
            yParent = node;
          }
        }
      }
      if(findX&&findY&&xParent!=yParent) {
        return true;
      }
      nodes = children;
    }
    return false;
  }
}