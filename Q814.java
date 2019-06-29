/**
 * Test cases:
 * 1: Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *  1               1
 *   \               \
 *    0     ->        0
 *   / \               \
 *  0  1               1
 *
 * 2: Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * Explanation:
 *           1            1
 *         /  \            \
 *        0    1    ->      1
 *       / \  / \            \
 *      0  0 0   1            1
 *
 * 3: Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 * Explanation:
 *           1             1
 *         /  \           / \
 *        1    0    ->   1   0
 *       / \  / \       / \   \
 *      1  1 0   1     1  1    1
 *     /
 *    0
 *    
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root) {
        if(root == null) {
            return false;
        }
        boolean leftOnes = false;
        boolean rightOnes = false;
        if(root.left != null) {
            leftOnes = containsOne(root.left);
            if(!leftOnes) {
                root.left = null;
            }
        }
        if(root.right!=null) {
            rightOnes = containsOne(root.right);
            if(!rightOnes) {
                root.right = null;
            }
        }
        return root.val == 1 || leftOnes || rightOnes;
    }
}