/**
 * Test cases:
 * 1: Input:
 *     2
 *    / \
 *   1   3
 * Output:
 * 1
 * 2: Input:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * 3: Input:
 *    0
 * Output:
 * 0
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

class Q513 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class BottomLeft {
    int depth;
    int pos;
    TreeNode node;

    BottomLeft(int depth, int pos, TreeNode node) {
      this.depth = depth;
      this.pos = pos;
      this.node = node;
    }
  }

  // Not using any extra space
  public int findBottomLeftValue(TreeNode root) {
    BottomLeft bottomLeft = new BottomLeft(0, 0, root);
    findBottomLeftValueHelper(root, 0, 0, bottomLeft);
    return bottomLeft.node.val;
  }

  private void findBottomLeftValueHelper(TreeNode root, int depth, int pos, BottomLeft bottomLeft) {
    if(root!=null) {
      if(depth>bottomLeft.depth) {
        bottomLeft.node = root;
        bottomLeft.depth = depth;
        bottomLeft.pos = pos;
      } else if(depth==bottomLeft.depth && pos<bottomLeft.pos) {
        bottomLeft.node = root;
        bottomLeft.pos = pos;
      }
      findBottomLeftValueHelper(root.left, depth+1, pos-1, bottomLeft);
      findBottomLeftValueHelper(root.right, depth+1, pos+1, bottomLeft);
    }
  }

  //Use Queue to store nodes of each layer
  public int findBottomLeftValue0(TreeNode root) {
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    TreeNode leftMost = null;
    while(!nodes.isEmpty()) {
      leftMost = nodes.peek();
      Queue<TreeNode> children = new LinkedList<>();
      while(!nodes.isEmpty()) {
        TreeNode cur = nodes.poll();
        if(cur.left!=null) {
          children.offer(cur.left);
        }
        if(cur.right!=null) {
          children.offer(cur.right);
        }
      }
      nodes = children;
    }
    return leftMost.val;
  }
}