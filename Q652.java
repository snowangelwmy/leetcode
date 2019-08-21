/**
 * Test cases:
 * 1: Input:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * Output:
 *       2
 *      /
 *     4
 *  and
 *       4
 *
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
import java.util.Map;
import java.util.HashMap;

class Q652 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> lookup = new HashMap<>();
    findDuplicateSubtreesHelper(root, ans, lookup);
    return ans;
  }

  private String findDuplicateSubtreesHelper(TreeNode node, List<TreeNode> ans, Map<String, Integer> lookup) {
    if(node==null) {
      return "#";
    }
    String id = node.val + "," + findDuplicateSubtreesHelper(node.left, ans, lookup) + "," + findDuplicateSubtreesHelper(node.right, ans, lookup);
    if(!lookup.containsKey(id)) {
      lookup.put(id, 0);
    }
    lookup.put(id, lookup.get(id)+1);
    if(lookup.get(id)==2) {
      ans.add(node);
    }
    return id;
  }
}