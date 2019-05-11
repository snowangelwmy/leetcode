/**
 * 1:  2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * 2:  5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if(root==null) return true;

        int val = root.val;
        if(min!=null && val<=min) { return false; }
        if(max!=null && val>=max) { return false; }

        if(!isValidBSTHelper(root.left, min, val)) { return false; }
        if(!isValidBSTHelper(root.right, val, max)) { return false; }
        return true;
    }
}