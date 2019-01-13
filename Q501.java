/**
 * Test cases:
 * 1: Input:
 *    1
 *     \
 *      2
 *     /
 *    2
 * Output: 2
 * 2: Input:
 * 2147483647
 * Output: 2147483647
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q501 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    private int currentValue = Integer.MIN_VALUE;
    private int currentCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int[] modes = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        modes = new int[modeCount];
        //reset global variables
        modeCount = 0;
        currentCount = 0;
        inOrder(root);
        return modes;
    }

    private void inOrder(TreeNode root) {
        if(root==null) return;
        inOrder(root.left);
        handleValue(root.val);
        inOrder(root.right);
    }

    private void handleValue(int value) {
        if(currentValue==value) {
            currentCount++;
        } else {
            currentValue = value;
            currentCount = 1;
        }
        if(currentCount>maxCount) {
            maxCount = currentCount;
            modeCount = 1;
        } else if(currentCount==maxCount) {
            if(modes!=null) {
                modes[modeCount] = value;
            }
            modeCount++;
        }
    }
}