/**
 * Test cases:
 * 1: Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,2,3]
 * 2: Input: [1,4,3,2]
 *     1
 *    / \
 *   4   3
 *  /
 * 2
 * Output: [1,4,2,3]
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
import java.util.Stack;

class Q144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Iteratively solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        //We have to use Stack instead of Queue here. Why?
        Stack<TreeNode> queue = new Stack<>();
        if(root==null) {
            return values;
        }
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.pop();
            values.add(curNode.val);
            if(curNode.right!=null) {
                queue.push(curNode.right);
            }
            if(curNode.left!=null) {
                queue.push(curNode.left);
            }
        }
        return values;
    }

    //Recursive solution
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        preorderTraversalHelper(root, values);
        return values;
    }

    private void preorderTraversalHelper(TreeNode root, List<Integer> values) {
        if(root==null) {
            return;
        }
        values.add(root.val);
        preorderTraversalHelper(root.left, values);
        preorderTraversalHelper(root.right, values);
    }
}