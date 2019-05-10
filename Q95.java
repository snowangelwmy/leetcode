/**
 * Test cases:
 * 1: Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 2: Input: 0
 * Output: []
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

class Q95 {
  public List<TreeNode> generateTrees(int n) {
    if(n<=0) {
      return new ArrayList<>();
    }
    return generateSubtrees(1, n);
  }

  public List<TreeNode> generateSubtrees(int start, int end) {
    List<TreeNode> res = new ArrayList<>();
    if(start>end) {
      res.add(null);
      return res;
    }

    for(int i=start; i<=end; i++) {
      List<TreeNode> leftTrees = generateSubtrees(start, i-1);
      List<TreeNode> rightTrees = generateSubtrees(i+1, end);
      for(TreeNode leftTree : leftTrees) {
        for(TreeNode rightTree : rightTrees) {
          TreeNode root = new TreeNode(i);
          root.left = leftTree;
          root.right = rightTree;
          res.add(root);
        }
      }
    }
    return res;
  }
}