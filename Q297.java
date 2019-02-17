/**
 * Test cases:
 * 1: You may serialize the following tree:
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
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
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Codec {
    private static final String delimiter = ",";
    private static final String nn = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildString(root, builder);
        return builder.toString();
    }

    private void buildString(TreeNode root, StringBuilder builder) {
        if(root==null) {
            builder.append(nn).append(delimiter);
        } else {
            builder.append(root.val).append(delimiter);
            buildString(root.left, builder);
            buildString(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> values = new LinkedList<>();
        values.addAll(Arrays.asList(data.split(delimiter)));
        return buildTree(values);
    }

    private TreeNode buildTree(Queue<String> values) {
        if(!values.isEmpty()) {
            String value = values.poll();
            if(value.equals(nn)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(value));
                node.left = buildTree(values);
                node.right = buildTree(values);
                return node;
            }
        }
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));