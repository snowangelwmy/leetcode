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