/**
 * Test cases:
 * 1: Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *       8
 *      / \
 *     5  10
 *    /\   \
 *   1 7   12
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q1008 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public class IndexContainer {
        private int index;

        public IndexContainer() {
            this.index = 0;
        }

        public int getValue() {
            return this.index;
        }

        public void increment() {
            this.index++;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null||preorder.length==0) {
            return null;
        }

        //Integer class is immutable in Java
        //Integer index = 0; //not work if using Integer directlly
        IndexContainer index = new IndexContainer();
        return bstFromPreorderHelper(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorderHelper(int[] preorder, IndexContainer index, int min, int max) {
        if(index.getValue()==preorder.length) {
            return null;
        }
        int val = preorder[index.getValue()];
        if(val < min || val > max) {
            return null;
        }

        index.increment();
        TreeNode root = new TreeNode(val);
        root.left = bstFromPreorderHelper(preorder, index, min, val);
        root.right = bstFromPreorderHelper(preorder, index, val, max);
        return root;
    }
}