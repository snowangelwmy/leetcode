/**
 * Test cases:
 * 1: Input & Output:
 * You may serialize the following tree:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * as "[5,3,2,#,#,4,#,#,6,#,7,#,#]"
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.lang.StringBuilder;

public class Codec {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  private final static String DELIMITOR = ",";
  private final static String NULL = "#";

  class Index {
    int val;

    Index(int val) {
      this.val = val;
    }
  }


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    serializeHelper(root, builder);
    return builder.toString().replaceAll(",$", "");
  }

  private void serializeHelper(TreeNode root, StringBuilder builder) {
    if(root==null) {
      builder.append(NULL).append(DELIMITOR);
      return;
    }

    builder.append(root.val).append(DELIMITOR);
    this.serializeHelper(root.left, builder);
    this.serializeHelper(root.right, builder);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data==null||data.length()==0) {
      return null;
    }

    String[] values = data.split(DELIMITOR+"");
    TreeNode root = deserializeHelper(values, new Index(0));
    return root;
  }

  private TreeNode deserializeHelper(String[] values, Index index) {
    String value = values[index.val];
    if(value.equals(NULL)) {
      index.val++;
      return null;
    }
    int num = Integer.parseInt(value);
    TreeNode root = new TreeNode(num);
    index.val++;
    root.left = deserializeHelper(values, index);
    root.right = deserializeHelper(values, index);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));