/**
 * Test cases:
 *  1: Input:
 *        7
 *       / \
 *      3  15
 *         /\
 *        9 20
 *  BSTIterator iterator = new BSTIterator(root);
 *  iterator.next();    // return 3
 *  iterator.next();    // return 7
 *  iterator.hasNext(); // return true
 *  iterator.next();    // return 9
 *  iterator.hasNext(); // return true
 *  iterator.next();    // return 15
 *  iterator.hasNext(); // return true
 *  iterator.next();    // return 20
 *  iterator.hasNext(); // return false
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

class BSTIterator {
    // next() and hasNext() run in average O(1) time and uses O(n) memory,
    // where n is the number of nodes in the tree.
    List<Integer> nums;
    int curIdx;

    public BSTIterator(TreeNode root) {
        nums = new ArrayList<Integer>();
        inOrderTraversal(root, nums);
        curIdx = -1;
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext()) {
            curIdx++;
            return nums.get(curIdx);
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (curIdx+1) < nums.size();
    }

    private void inOrderTraversal(TreeNode root, List<Integer> nums) {
        if(root==null) {
            return;
        }
        if(root.left!=null) {
            inOrderTraversal(root.left, nums);
        }
        nums.add(root.val);
        if(root.right!=null) {
            inOrderTraversal(root.right, nums);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */