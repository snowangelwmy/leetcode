/**
 * Test cases:
 * 1: Input:
 * A binary tree as following:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 * v = 1
 * d = 2
 * Output:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 * 2: Input:
 * A binary tree as following:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 * v = 1
 * d = 3
 * Output:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
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

import java.util.Queue;
import java.util.LinkedList;

class Q623 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if(d<1) {
      return root;
    }
    if(d==1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }
    if(root==null) {
      return root;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    int depth = 1;
    while(depth<d-1&&!nodes.isEmpty()) {
      Queue<TreeNode> children = new LinkedList<>();
      while(!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        if(node.left!=null) {
          children.offer(node.left);
        }
        if(node.right!=null) {
          children.offer(node.right);
        }
      }
      nodes = children;
      if(!nodes.isEmpty()) {
        depth++;
      }
    }
    if(depth<d-1) {
      return root;
    }
    while(!nodes.isEmpty()) {
      TreeNode node = nodes.poll();
      TreeNode newLeft = new TreeNode(v);
      newLeft.left = node.left;
      node.left = newLeft;
      TreeNode newRight = new TreeNode(v);
      newRight.right = node.right;
      node.right = newRight;
    }
    return root;
  }
}