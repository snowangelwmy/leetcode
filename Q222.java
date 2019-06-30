/**
 * Test cases:
 * 1: Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * Output: 6
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
class Q222 {
    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int count = 1;
        if(root.left!=null) {
            count += countNodes(root.left);
        }
        if(root.right!=null) {
            count += countNodes(root.right);
        }
        return count;
    }
}