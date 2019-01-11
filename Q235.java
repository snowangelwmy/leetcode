/**
 * Test cases:
 *      6
 *     / \
 *    2  8
 *   /\  /\
 *  0 4 7 9
 *    /\
 *   3 5
 * 1: Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 2: Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q235 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  //Iterative Approach
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if(p==null||q==null){
      return null;
    }

    TreeNode node = root;
    int pValue = p.val;
    int qValue = q.val;
    while(node!=null){
      int rValue = node.val;
      if(pValue>rValue&&qValue>rValue){
        //both p and q are at the right subtree
        node = node.right;
      } else if(pValue<rValue&&qValue<rValue){
        //both p and q are at the left subtree
        node = node.left;
      } else {
        return node;
      }
    }

    return null;
  }

  //Recursive Approach
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null||p==null||q==null){
      return null;
    }

    int rValue = root.val;
    int pValue = p.val;
    int qValue = q.val;
    if(pValue>rValue&&qValue>rValue){
      //both p and q are at the right subtree
      return lowestCommonAncestor1(root.right, p, q);
    } else if(pValue<rValue&&qValue<rValue){
      //both p and q are at the left subtree
      return lowestCommonAncestor1(root.left, p, q);
    } else {
      return root;
    }
  }
}