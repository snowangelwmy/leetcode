/**
 * Test cases:
 * 1: Input:
 *    1
 *     \
 *      3
 *     /
 *    2
 * Output: 1
 * Explanation: The minimum absolute difference is 1, which is the difference
 * between 2 and 1 (or between 2 and 3).
 *
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

class Q530 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<values.size()-1; i++) {
            int diff = values.get(i+1) - values.get(i);
            if(diff<minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> values) {
        if(root==null) {
            return;
        }
        inOrderTraversal(root.left, values);
        values.add(root.val);
        inOrderTraversal(root.right, values);
    }
}