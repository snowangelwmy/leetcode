/**
 * Test cases:
 * 1: Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [3,2,1]
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
import java.util.Set;
import java.util.HashSet;

class Q145 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  //Iterative solution
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> nums = new ArrayList<>();
    Stack<TreeNode> nodes = new Stack<>();
    Set<TreeNode> visited = new HashSet<>();
    if(root!=null) {
      nodes.push(root);
      visited.add(root);
    }
    while(!nodes.isEmpty()) {
      TreeNode node = nodes.peek();

      // if the current node has a non-visited left child, then add all the left child in the left subtree to the stack
      while(node.left!=null && !visited.contains(node.left)) {
        node = node.left;
        nodes.push(node);
        visited.add(node);
        continue;
      }

      // if the current node has a non-visited right child, then add it to the stack
      if(node.right!=null && !visited.contains(node.right)) {
        node = node.right;
        nodes.push(node);
        visited.add(node);
        continue;
      }

      // if the current node does not have any left or right child,
      // or both its left and right substree are already visited, then we can pop it from the stack and add it to the return list
      node = nodes.pop();
      nums.add(node.val);
    }
    return nums;
  }

  //Recursive solution
  public List<Integer> postorderTraversal0(TreeNode root) {
    List<Integer> nodes = new ArrayList<>();
    postorderTraversalHelper(root, nodes);
    return nodes;
  }

  private void postorderTraversalHelper(TreeNode root, List<Integer> nodes) {
    if(root==null) {
      return;
    }

    //root!=null
    postorderTraversalHelper(root.left, nodes);
    postorderTraversalHelper(root.right, nodes);
    nodes.add(root.val);
  }
}