/**
 * Test cases:
 * 1: Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * 2: Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Set;
import java.util.HashSet;

class Q653 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean findTarget(TreeNode root, int k) {
    if(root==null) {
      return false;
    }
    Set<Integer> lookup = new HashSet<>();
    boolean result = findTargetHelper(root, lookup, k);
    return result;
  }

  private boolean findTargetHelper(TreeNode root, Set<Integer> lookup, int k) {
    if(lookup.contains(k-root.val)) {
      return true;
    }
    lookup.add(root.val);
    boolean left = false;
    if(root.left!=null) {
      left = findTargetHelper(root.left, lookup, k);
    }
    boolean right = false;
    if(root.right!=null) {
      right = findTargetHelper(root.right, lookup, k);
    }
    return left || right;
  }
}