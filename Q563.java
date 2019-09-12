/**
 * Test cases:
 * 1: Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * 2: Input:
 *         1
 *        / \
 *       2   3
 *      /   /
 *     4   5
 * Output: 11
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Q563 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class NodeInfo {
    int sum;
    int tilt;

    NodeInfo(int sum, int tilt) {
      this.sum = sum;
      this.tilt = tilt;
    }
  }

  public int findTilt(TreeNode root) {
    if(root==null) {
      return 0;
    }
    NodeInfo nodeInfo = findTiltHelper(root);
    return nodeInfo.tilt;
  }

  private NodeInfo findTiltHelper(TreeNode root) {
    if(root.left==null && root.right==null) {
      return new NodeInfo(root.val, 0);
    }
    int sum = root.val;
    int tilt = 0;
    NodeInfo leftNodeInfo = new NodeInfo(0, 0);
    if(root.left!=null) {
      leftNodeInfo = this.findTiltHelper(root.left);
    }
    sum += leftNodeInfo.sum;
    tilt += leftNodeInfo.tilt;
    NodeInfo rightNodeInfo = new NodeInfo(0, 0);
    if(root.right!=null) {
      rightNodeInfo = this.findTiltHelper(root.right);
    }
    sum += rightNodeInfo.sum;
    tilt += rightNodeInfo.tilt;
    tilt += Math.abs(leftNodeInfo.sum-rightNodeInfo.sum);
    return new NodeInfo(sum, tilt);
  }
}