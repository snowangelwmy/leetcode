/**
 * Test cases:
 * 1: Input: Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to search: 2
 * Output: You should return this subtree:
 *       2
 *      / \
 *     1   3
 * 2: Input: Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 5
 * Output: Since there is no node with value 5, we should return NULL.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) {
            return null;
        }
        if(root.val==val) {
            return root;
        } else if(root.val<val) {
            return searchBST(root.right, val);
        } else {//root.val>val
            return searchBST(root.left, val);
        }
    }
}