/**
 * Test cases:
 * 1: Input: [-10,-3,0,5,9]
 * One possible Output: [0,-3,9,-10,null,5],
 * which represents the following height balanced BST:
 *      0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }

        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int low, int high){
        if(low<=high){
            int mid = (low+high)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, low, mid-1);
            root.right = buildBST(nums, mid+1, high);
            return root;
        }

        return null;
    }
}