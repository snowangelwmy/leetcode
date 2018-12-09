/**
 * Test cases:
 * 1: Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> values = new LinkedList<>();
        if(root==null){
            return values;
        }

        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);
        levelTraversal(parents, values);
        return values;
    }

    private static void levelTraversal(Queue<TreeNode> parents, List<List<Integer>> values){
        List<Integer> pValues = new ArrayList<>();
        Queue<TreeNode> children = new LinkedList<>();
        while(!parents.isEmpty()){
            TreeNode node = parents.poll();
            pValues.add(node.val);
            if(node.left!=null){
                children.add(node.left);
            }
            if(node.right!=null){
                children.add(node.right);
            }
        }
        values.add(0, pValues);
        if(!children.isEmpty()){
            levelTraversal(children, values);
        }
    }
}