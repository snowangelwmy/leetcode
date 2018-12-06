/**
 * Test cases:
 * 1: Input:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * Output: true
 *
 * 2: Input:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Output: false
 *
 * 3: Input:
 *      19
 *     /  \
 *   -42  -42
 *     \   /
 *     76 76
 *      \  \
 *      13 13
 * Output: false
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
import java.util.LinkedList;

class Solution {
    //Recursive approach
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) {
            return true;
        } else if(root1==null||root2==null) {
            return false;
        } else { //root1!=null&&root2!=null
            return (root1.val==root2.val && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left));
        }
    }

    //Iterative approach
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> nextNodes = new LinkedList<>();
        nextNodes.add(root);
        nextNodes.add(root);

        while(!nextNodes.isEmpty()){
            TreeNode node1 = nextNodes.poll();
            TreeNode node2 = nextNodes.poll();
            if(node1==null&&node2==null){
                continue;
            } else if(node1==null||node2==null||node1.val!=node2.val){
                return false;
            }
            //node1!=null&&node2!=null
            nextNodes.add(node1.left);
            nextNodes.add(node2.right);
            nextNodes.add(node1.right);
            nextNodes.add(node2.left);
        }

        return true;
    }
}