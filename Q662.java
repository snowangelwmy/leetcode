/**
 * Test cases:
 * 1: Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * 2: Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * 3: Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * 4: Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Queue;
import java.lang.Math;
import java.util.LinkedList;

class Q662 {

    private class TreeNodePlus {
        TreeNode node;
        int level;
        int pos;

        TreeNodePlus(TreeNode node, int level, int pos) {
            this.node = node;
            this.level = level;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }

        TreeNodePlus rootPlus = new TreeNodePlus(root, 0, 0);
        Queue<TreeNodePlus> nodes = new LinkedList<>();
        nodes.add(rootPlus);
        int curLevel = 0;
        int leftPos = 0;
        int maxWidth = 0;
        while(!nodes.isEmpty()) {
            TreeNodePlus curNode = nodes.poll();
            if(curNode.node!=null) {
                nodes.add(new TreeNodePlus(curNode.node.left, curNode.level+1, 2*curNode.pos));
                nodes.add(new TreeNodePlus(curNode.node.right, curNode.level+1, 2*curNode.pos+1));
                if(curNode.level!=curLevel) {
                    curLevel = curNode.level;
                    leftPos = curNode.pos;
                } else {
                    maxWidth = Math.max(maxWidth, curNode.pos - leftPos + 1);
                }
            }
        }
        return maxWidth;
    }


}