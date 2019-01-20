/**
 * Test cases:
 * 1: Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q538 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    private class Sum {
        private int sum;

        public Sum(int sum) {
            this.sum = sum;
        }

        public int getSum() {
            return this.sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if(root==null) {
            return null;
        }
        convertBST(root, new Sum(0));
        return root;
    }

    private void convertBST(TreeNode root, Sum sum) {
        if(root==null) {
            return;
        }

        convertBST(root.right, sum);
        sum.setSum(sum.getSum()+root.val);
        root.val = sum.getSum();
        System.out.println("sum:" + sum.getSum() + "root.val:"+ root.val);
        convertBST(root.left, sum);
    }
}