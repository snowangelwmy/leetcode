/*
 * Test cases:
 * 1: Input: head = 1 -> 2, 1.random = 2, 2.random = 2
 * Output: newHead = 1 -> 2, 1.random = 2, 2.random = 2
 *
 *
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

import java.util.Map;
import java.util.HashMap;

class Q138 {

  class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }

  public Node copyRandomList(Node head) {
    if(head==null) {
      return null;
    }

    Map<Node, Node> lookup = new HashMap<>();
    Node newHead = null;
    Node newPointer = null;
    Node pointer = head;
    while(pointer!=null) {
      Node node = new Node(pointer.val, null, null);
      lookup.put(pointer, node);
      if(newPointer==null) {
        newHead = node;
        newPointer = node;
      } else {
        newPointer.next = node;
        newPointer = node;
      }
      pointer = pointer.next;
    }

    pointer = head;
    newPointer = newHead;
    while(pointer!=null) {
      newPointer.random = lookup.get(pointer.random);
      newPointer = newPointer.next;
      pointer = pointer.next;
    }
    return newHead;
  }
}