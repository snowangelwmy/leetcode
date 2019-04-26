/**
 * Test cases:
 * 1: Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * 2: Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
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

class Q230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        return nodes.get(k-1);
    }

    private void inOrderTraversal(TreeNode root, List<Integer> nodes) {
        if(root==null) {
            return;
        }
        if(root.left!=null) {
            inOrderTraversal(root.left, nodes);
        }
        nodes.add(root.val);
        if(root.right!=null) {
            inOrderTraversal(root.right, nodes);
        }
    }
}