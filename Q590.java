/*
 * Test cases:
 * 1: Input:
 *             1
 *          /  |  \
 *         3   2   4
 *        / |
 *       5  6
 * Output: [5,6,3,2,4,1].
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
import java.util.Collections;

class Q590 {

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
  public List<Integer> postorder(Node root) {
    List<Integer> values = new ArrayList<>();
    if(root==null) {
      return values;
    }
    Stack<Node> nodes = new Stack<>();
    nodes.push(root);
    while(!nodes.isEmpty()) {
      Node node = nodes.pop();
      values.add(node.val);
      if(node.children!=null&&node.children.size()>0) {
        for(Node child : node.children) {
          if(child!=null) {
            nodes.push(child);
          }
        }
      }
    }
    Collections.reverse(values);
    return values;
  }

  //Approache 1: Recursive solution
  public List<Integer> postorder0(Node root) {
    List<Integer> values = new ArrayList<>();
    postorderHelper(root, values);
    return values;
  }

  private void postorderHelper(Node root, List<Integer> values) {
    if(root==null) {
      return;
    }

    List<Node> children = root.children;
    if(children!=null && children.size()>0) {
      for(Node child : children) {
        postorderHelper(child, values);
      }
    }
    values.add(root.val);
  }
}