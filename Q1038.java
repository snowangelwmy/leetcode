/**
 * Test cases:
 * 1: Input: Given the tree:
 *          4
 *        /   \
 *       1     6
 *      / \   / \
 *     0  2  5  7
 *         \     \
 *         3     8
 * Output: You should return this subtree:
 *          30
 *        /    \
 *       36    21
 *      / \   / \
 *     36 35 26 15
 *         \     \
 *         33    8
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q1038 {
    public TreeNode bstToGst(TreeNode root) {
        reversedInOrderTraversal(root, new TreeNode(0));
        return root;
    }

    private void reversedInOrderTraversal(TreeNode root, TreeNode sum) {
        if(root==null) { return; }
        reversedInOrderTraversal(root.right, sum);
        sum.val += root.val;
        root.val = sum.val;
        reversedInOrderTraversal(root.left, sum);
    }
}