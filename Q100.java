/**
 * Test cases:
 * 1:
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 * 2:
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * 3:
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
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
import java.util.List;
import java.util.ArrayList;

class Q100 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pVals = new ArrayList<>();
        preOrderTraversal(p, pVals);
        List<Integer> qVals = new ArrayList<>();
        preOrderTraversal(q, qVals);
        if(pVals.size() != qVals.size()){
            return false;
        }

        for(int i=0; i<pVals.size(); i++){
            if((pVals.get(i) == null && qVals.get(i) != null)
                    || (pVals.get(i) != null && qVals.get(i) == null)
                    || (pVals.get(i) != null && qVals.get(i) != null && !pVals.get(i).equals(qVals.get(i)))) {
                return false;
            }
        }

        return true;
    }

    private static void preOrderTraversal(TreeNode root, List<Integer> vals) {
        if(root==null) {
            vals.add(null);
            return;
        }

        vals.add(new Integer(root.val));
        preOrderTraversal(root.left, vals);
        preOrderTraversal(root.right, vals);
    }
}