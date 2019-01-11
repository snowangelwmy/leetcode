/**
 * Test cases:
 * 1: Input:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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

class Q257 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    if(root==null){
      return paths;
    }

    List<String> parents = new ArrayList<>();
    depthFirstSearch(root, paths, parents);
    return paths;
  }

  private void depthFirstSearch(TreeNode root, List<String> paths, List<String> parents) {
    int index = parents.size();
    parents.add(String.valueOf(root.val));
    if(root.left==null&&root.right==null){ //root is a leaf node
      paths.add(String.join("->", parents));
    } else {
      if(root.left!=null){
        depthFirstSearch(root.left, paths, parents);
      }
      if(root.right!=null){
        depthFirstSearch(root.right, paths, parents);
      }
    }
    parents.remove(index);
  }
}