/**
 * Test cases:
 * 1: Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
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
import java.util.List;
import java.util.ArrayList;

class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) { return result; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        while(!queue.isEmpty()) {
            TreeNode last = null;
            for(int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }
                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
                last = cur;
            }
            result.add(last.val);
            size = queue.size();
        }
        return result;
    }
}