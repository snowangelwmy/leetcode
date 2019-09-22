/**
 * 1: Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *      1
 *    /  \
 *   2    3
 *  / |  / |
 * 4  5 6  7
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

class Q889 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    Map<Integer, Integer> lookup = new HashMap<>();
    for(int i=0; i<post.length; i++) {
      lookup.put(post[i], i);
    }

    TreeNode root = constructFromPrePostHelper(pre, 0, lookup, post, 0, post.length-1);
    return root;
  }

  private TreeNode constructFromPrePostHelper(int[] pre, int next, Map<Integer, Integer> lookup, int[] post, int start, int end) {
    if(start>end) {
      return null;
    }
    if(start==end) {
      return new TreeNode(post[start]);
    }
    //start<end
    TreeNode root = new TreeNode(pre[next]);
    int leftValue = pre[next+1];
    int leftInPost = lookup.get(leftValue);
    int leftLength = leftInPost-start+1;
    root.left = constructFromPrePostHelper(pre, next+1, lookup, post, start, leftInPost);
    root.right = constructFromPrePostHelper(pre, next+1+leftLength, lookup, post, leftInPost+1, end-1);
    return root;
  }
}