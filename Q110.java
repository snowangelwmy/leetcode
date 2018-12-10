/**
 * Test cases:
 * 1: Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: true
 * 2: Input:
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Output: false
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.lang.Math;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getDepth(root.left)-getDepth(root.right))<=1;
    }

    private int getDepth(TreeNode node) {
        if(node==null){
            return 0;
        }

        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}