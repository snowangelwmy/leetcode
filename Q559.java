/*
 * Test cases:
 * 1: Input:
 *       1
 *    /  \  \
 *   3   2  4
 *  / \
 * 5   6
 * Output: 3
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

class Q559 {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  class MaxDepth {
    int val;

    MaxDepth(int val) {
      this.val = val;
    }
  }

  public int maxDepth(Node root) {
    if(root==null) {
      return 0;
    }
    MaxDepth maxDepth = new MaxDepth(0);
    maxDepthHelper(root, 1, maxDepth);
    return maxDepth.val;
  }

  private void maxDepthHelper(Node root, int depth, MaxDepth maxDepth) {
    if(root.children==null||root.children.size()==0) {
      if(depth>maxDepth.val) {
        maxDepth.val = depth;
      }
      return;
    }
    for(Node child : root.children) {
      maxDepthHelper(child, depth+1, maxDepth);
    }
  }
}