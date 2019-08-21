/**
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

class Q94 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  // Recursive solution
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraversalHelper(root, result);
    return result;
  }

  private void inorderTraversalHelper(TreeNode root, List<Integer> result) {
    if(root==null) {
      return;
    }
    inorderTraversalHelper(root.left, result);
    result.add(root.val);
    inorderTraversalHelper(root.right, result);
  }
}