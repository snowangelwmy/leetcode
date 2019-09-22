/*
 * Test cases:
 * 1: Input:
 *             1
 *          /  |  \
 *         3   2   4
 *        / |
 *       5  6
 * Output: [1,3,5,6,2,4].
 *
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

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Q589 {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  //Approache 2: Iterative solution
  public List<Integer> preorder(Node root) {
    List<Integer> values = new ArrayList<>();
    if(root==null) {
      return values;
    }
    Stack<Node> nodes = new Stack<>();
    nodes.push(root);
    while(!nodes.isEmpty()) {
      Node node = nodes.pop();
      values.add(node.val);
      List<Node> children = node.children;
      if(children!=null&&children.size()>0) {
        for(int i=children.size()-1; i>=0; i--) {
          if(children.get(i)!=null) {
            nodes.push(children.get(i));
          }
        }
      }
    }
    return values;
  }


  //Approache 1: Recursive solution
  public List<Integer> preorder0(Node root) {
    List<Integer> values = new ArrayList<>();
    preorderHelper(root, values);
    return values;
  }

  private void preorderHelper(Node root, List<Integer> values) {
    if(root==null) {
      return;
    }

    values.add(root.val);
    List<Node> children = root.children;
    if(children!=null && children.size()>0) {
      for(Node child : children) {
        preorderHelper(child, values);
      }
    }
  }
}
