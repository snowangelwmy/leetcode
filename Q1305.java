/**
 * Test cases:
 * 1: Input: root1 = [2,1,4], root2 = [1,0,3]
 *    2         1
 *   / \       / \
 *  1  4      0  3
 * Output: [0,1,1,2,3,4]
 * 2: Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * 3: Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * 4: Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * 5: Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.ArrayList;

class Q1305 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();

        List<Integer> nums1 = new ArrayList<>();
        inorderTraversal(root1, nums1);

        List<Integer> nums2 = new ArrayList<>();
        inorderTraversal(root2, nums2);

        int i = 0;
        int j = 0;
        while(i<nums1.size() && j<nums2.size()) {
            if(nums1.get(i)<=nums2.get(j)) {
                result.add(nums1.get(i));
                i++;
            } else {
                result.add(nums2.get(j));
                j++;
            }
        }

        while(i<nums1.size()) {
            result.add(nums1.get(i));
            i++;
        }

        while(j<nums2.size()) {
            result.add(nums2.get(j));
            j++;
        }

        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> nums) {
        if(root==null) {
            return;
        }

        inorderTraversal(root.left, nums);
        nums.add(root.val);
        inorderTraversal(root.right, nums);
    }
}