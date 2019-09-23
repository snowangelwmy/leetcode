/**
 * Test cases:
 * 1: Input:
 *           3
 *         /   \
 *        5     1
 *      /  \   / \
 *     6   2  9   8
 *        / \
 *       7  4
 *
 *           3
 *         /   \
 *        5     1
 *      /  \   / \
 *     2   4  9   8
 *    / \
 *   6  7
 * Output: true
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

class Q872 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList<>();
    findLeafSeq(root1, leaves1);
    List<Integer> leaves2 = new ArrayList<>();
    findLeafSeq(root2, leaves2);
    if(leaves1.size()!=leaves2.size()) {
      return false;
    }
    for(int i=0; i<leaves1.size(); i++) {
      if(leaves1.get(i)!=leaves2.get(i)) {
        return false;
      }
    }
    return true;
  }

  private void findLeafSeq(TreeNode root, List<Integer> leaves) {
    if(root==null) {
      return;
    }
    if(root.left==null&&root.right==null) {
      leaves.add(root.val);
      return;
    }
    if(root.left!=null) {
      findLeafSeq(root.left, leaves);
    }
    if(root.right!=null) {
      findLeafSeq(root.right, leaves);
    }
  }
}