/*
 * Test cases:
 * 1: Input:
 *       1
 *    /  |  \
 *   3   2  4
 *  / \
 * 5  6
 * Output:
 *  [
 *    [1],
 *    [3,2,4],
 *    [5,6]
 *  ]
 *
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> values = new ArrayList<>();
    if(root==null){
      return values;
    }

    Queue<Node> parents = new LinkedList<>();
    parents.add(root);
    levelTraversal(parents, values);
    return values;
  }

  private void levelTraversal(Queue<Node> parents, List<List<Integer>> values) {
    List<Integer> pValues = new ArrayList<>();
    Queue<Node> children = new LinkedList<>();
    while(parents.size()>0){
      Node pNode = parents.poll();
      pValues.add(pNode.val);
      if(pNode.children!=null){
        List<Node> pChildren = pNode.children;
        for(int i=0; i<pChildren.size(); i++){
          Node cNode = pChildren.get(i);
          if(cNode!=null){
            children.add(cNode);
          }
        }
      }
    }
    values.add(pValues);
    if(children.size()>0){
      levelTraversal(children, values);
    }
  }
}