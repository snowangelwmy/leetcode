/**
 * Test cases:
 * 1: Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
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
import java.util.Stack;

class Q94 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  //Iteratively solution
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root==null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while(cur!=null || !stack.isEmpty()) {
      while(cur!=null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      result.add(cur.val);
      cur = cur.right;
    }
    return result;
  }

  // Recursive solution
  public List<Integer> inorderTraversal0(TreeNode root) {
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