/**
 * Test cases:
 * 1: Input: For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * Output: The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q114 {
    public void flatten(TreeNode root) {
        if(root == null) { return; }
        flatten(root.left);
        flatten(root.right);

        TreeNode tailLeft = getTail(root.left);
        if(tailLeft == null) {
            return;
        } else {
            tailLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    private TreeNode getTail(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode tail = root;
        while(tail.right != null) {
            tail = tail.right;
        }
        return tail;
    }
}