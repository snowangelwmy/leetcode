/**
 * Test cases:
 * 1: Input:
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Output:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 2: Input:
 * preorder = []
 * inorder = []
 * Output:
 *     null
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

class Q105 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class PreorderNext {
    int val;

    PreorderNext(int val) {
      this.val = val;
    }
  }

  // Avoid generating preorder and inorder arrays - memory and runtime friendly
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder==null || inorder==null || preorder.length!=inorder.length || preorder.length==0) {
      return null;
    }

    Map<Integer, Integer> inorderLookup = new HashMap<>();
    for(int i=0; i<inorder.length; i++) {
      inorderLookup.put(inorder[i], i);
    }

    return buildTreeHelper(preorder, new PreorderNext(0), inorderLookup, 0, inorder.length-1);
  }

  private TreeNode buildTreeHelper(int[] preorder, PreorderNext preorderNext, Map<Integer, Integer> inorderLookup, int inorderStart, int inorderEnd) {
    if(inorderStart>inorderEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preorderNext.val]);
    if(inorderStart==inorderEnd) {
      preorderNext.val++;
      return root;
    }
    //inorderStart<inorderEnd
    int inorderIndex = inorderLookup.get(preorder[preorderNext.val]);
    preorderNext.val++;
    root.left = this.buildTreeHelper(preorder, preorderNext, inorderLookup, inorderStart, inorderIndex-1);
    root.right = this.buildTreeHelper(preorder, preorderNext, inorderLookup, inorderIndex+1, inorderEnd);
    return root;
  }


  // Keep generating preorder and inorder arrays - not memory friendly
  public TreeNode buildTree0(int[] preorder, int[] inorder) {
    if(preorder==null || inorder==null || preorder.length!=inorder.length || preorder.length==0) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[0]);
    if(preorder.length==1) {
      return root;
    }

    int rootIndex = -1;
    for(int i=0; i<inorder.length; i++) {
      if(inorder[i]==preorder[0]) {
        rootIndex = i;
      }
    }
    int[] leftInorder = new int[rootIndex];
    int[] rightInorder = new int[inorder.length-rootIndex-1];
    for(int i=0; i<inorder.length; i++) {
      if(i<rootIndex) {
        leftInorder[i] = inorder[i];
      } else if(i>rootIndex) {
        rightInorder[i-rootIndex-1] = inorder[i];
      }
    }
    int[] leftPreorder = new int[rootIndex];
    int[] rightPreorder = new int[preorder.length-rootIndex-1];
    for(int i=1; i<preorder.length; i++) {
      if(i<rootIndex+1) {
        leftPreorder[i-1] = preorder[i];
      } else if(i>rootIndex) {
        rightPreorder[i-rootIndex-1] = preorder[i];
      }
    }
    TreeNode left = buildTree(leftPreorder, leftInorder);
    TreeNode right = buildTree(rightPreorder, rightInorder);
    root.left = left;
    root.right = right;
    return root;
  }
}