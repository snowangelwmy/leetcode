/**
 * Test cases:
 * 1: Input & Output:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 2: Input & Output:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Stack;

class Q143 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public void reorderList(ListNode head) {
    if(head==null) {
      return;
    }
    Stack<ListNode> lookup = new Stack<>();
    int count = 0;
    ListNode pointer = head;
    while(pointer!=null) {
      lookup.push(pointer);
      count++;
      pointer = pointer.next;
    }
    ListNode current = head;
    int num = 0;
    for(int i=0; i<count/2; i++) {
      ListNode temp = current.next;
      ListNode next = lookup.pop();
      current.next = next;
      next.next = temp;
      num += 2;
      current = temp;
    }
    current.next = null;
    return;
  }
}
