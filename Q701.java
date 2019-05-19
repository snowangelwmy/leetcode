/**
 * Test cases:
 * 1: Input:
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * Output:
 * You can return this binary search tree:
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) { return new TreeNode(val); }
        if(root.val>val) {
            root.left = insertIntoBST(root.left, val);
        } else if(root.val<val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}