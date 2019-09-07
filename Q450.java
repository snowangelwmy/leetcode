/**
 * Test cases:
 * 1: Input: root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * Output:
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;h
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q450 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if(root==null) {
      return null;
    }
    if(root.val>key) {
      root.left = deleteNode(root.left, key);
    } else if(root.val<key) {
      root.right = deleteNode(root.right, key);
    } else {
      if(root.left==null) {
        return root.right;
      }
      if(root.right==null) {
        return root.left;
      }
      TreeNode leftGreatest = root.left;
      while(leftGreatest.right!=null) {
        leftGreatest = leftGreatest.right;
      }
      root.val = leftGreatest.val;
      root.left = deleteNode(root.left, leftGreatest.val);
    }
    return root;
  }
}