/*
 * Test cases:
 * 1: Input:
 *        1
 *      /   \
 *     2     3
 *    / \   / \
 *   4  5  6   7
 * Output:
 *        1 -> null
 *      /   \
 *     2 --> 3 -> null
 *    / \   / \
 *   4->5->6->7 -> null
 *
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.Queue;
import java.util.LinkedList;

class Q116 {

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  // Avoid using extra space
  public Node connect(Node root) {
    Node cur = root;
    while(cur!=null) {
      Node dummy = new Node();
      Node ptr = dummy;
      while(cur!=null) {
        if(cur.left!=null) {
          ptr.next = cur.left;
          ptr = ptr.next;
        }
        if(cur.right!=null) {
          ptr.next = cur.right;
          ptr = ptr.next;
        }
        cur = cur.next;
      }
      cur = dummy.next;
    }
    return root;
  }

  // Using extra space: Queue to store nodes in the same level
  public Node connect0(Node root) {
    if(root==null) {
      return null;
    }

    Queue<Node> nodes = new LinkedList<>();
    nodes.offer(root);
    while(!nodes.isEmpty()) {
      Queue<Node> childrenNodes = new LinkedList<>();
      while(!nodes.isEmpty()) {
        Node node = nodes.poll();
        node.next = nodes.peek();
        if(node.left!=null) {
          childrenNodes.offer(node.left);
        }
        if(node.right!=null) {
          childrenNodes.offer(node.right);
        }
      }
      nodes = childrenNodes;
    }
    return root;
  }
}