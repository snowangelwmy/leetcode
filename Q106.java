/**
 * Test cases:
 * 1: Input:
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Output:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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

import java.util.Map;
import java.util.HashMap;

class Q106 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class PostorderNext {
    int val;

    PostorderNext(int val) {
      this.val = val;
    }
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder==null || postorder==null || inorder.length!=postorder.length || inorder.length==0) {
      return null;
    }

    Map<Integer, Integer> inorderLookup = new HashMap<>();
    for(int i=0; i<inorder.length; i++) {
      inorderLookup.put(inorder[i], i);
    }

    return this.buildTreeHelper(inorderLookup, 0, inorder.length-1, postorder, new PostorderNext(postorder.length-1));
  }

  private TreeNode buildTreeHelper(Map<Integer, Integer> inorderLookup, int inorderStart, int inorderEnd, int[] postorder, PostorderNext postorderNext) {
    if(inorderStart>inorderEnd) {
      return null;
    }

    //inorderStart<=inorderEnd
    TreeNode root = new TreeNode(postorder[postorderNext.val]);
    if(inorderStart==inorderEnd) {
      postorderNext.val--;
      return root;
    }

    int inorderIndex = inorderLookup.get(postorder[postorderNext.val]);
    postorderNext.val--;
    root.right = this.buildTreeHelper(inorderLookup, inorderIndex+1, inorderEnd, postorder, postorderNext);
    root.left = this.buildTreeHelper(inorderLookup, inorderStart, inorderIndex-1, postorder, postorderNext);
    return root;
  }
}