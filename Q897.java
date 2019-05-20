/**
 * Test cases:
 * 1: Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
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

class Q897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inOrderTraversal(root, vals);
        TreeNode temp = new TreeNode(0);
        TreeNode cur = temp;
        for(Integer val : vals) {
            TreeNode node = new TreeNode(val);
            cur.right = node;
            cur = node;
        }
        return temp.right;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> vals) {
        if(root==null) {
            return;
        }

        inOrderTraversal(root.left, vals);
        vals.add(root.val);
        inOrderTraversal(root.right, vals);
    }
}