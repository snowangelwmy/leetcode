/**
 * Test cases:
 * 1: Input: Given the tree:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 * Output: You should return this tree:
 *     1
 *       \
 *        2
 * 2: Input: Given the tree:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 * Output: You should return this tree:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) { return root; }
        if(root.val < L) { return trimBST(root.right, L, R); }
        if(root.val > R) { return trimBST(root.left, L, R); }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}