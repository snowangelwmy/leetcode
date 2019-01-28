/**
 * Test cases:
 * 1: Input:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output: 2
 * 2: Input:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 2
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q687 {
    public class Length {
        private int length;
    }

    public int longestUnivaluePath(TreeNode root) {
        Length lpLength = new Length();
        longestUnivaluePath(root, lpLength);
        return lpLength.length;
    }

    private int longestUnivaluePath(TreeNode root, Length lpLength) {
        if(root==null) {
            return 0;
        }

        int left = longestUnivaluePath(root.left, lpLength);
        int right = longestUnivaluePath(root.right, lpLength);
        int arrowLeft = 0, arrowRight = 0;
        if(root.left!=null&&root.val==root.left.val) {
            arrowLeft += left + 1;
        }
        if(root.right!=null&&root.val==root.right.val) {
            arrowRight += right + 1;
        }
        lpLength.length = Math.max(lpLength.length, arrowLeft+arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}