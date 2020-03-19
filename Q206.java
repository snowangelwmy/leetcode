/**
 * Test cases:
 * 1: Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Stack;

class Q206 {

  public class ListNode {
      int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }

  //reverse recursively
  public ListNode reverseList(ListNode head) {
    if(head==null||head.next==null){
      return head;
    }

    ListNode reversed = reverseList(head.next);
    ListNode pointer = reversed;
    while(pointer.next!=null){
      pointer = pointer.next;
    }
    pointer.next = head;
    head.next = null;
    return reversed;
  }

  //reverse iteratively
  public ListNode reverseList1(ListNode head) {
    if(head==null||head.next==null) {
      return head;
    }

    Stack<ListNode> stack = new Stack<>();
    ListNode pointer = head;
    while(pointer!=null) {
      stack.push(pointer);
      pointer = pointer.next;
    }

    ListNode reversedHead = null;
    ListNode reversedPointer = null;
    while(!stack.isEmpty()) {
      ListNode next = stack.pop();
      next.next = null;
      if(reversedHead==null) {
        reversedHead = next;
        reversedPointer = next;
      } else {
        reversedPointer.next = next;
        reversedPointer = reversedPointer.next;
      }
    }

    return reversedHead;
  }

  public ListNode reverseList0(ListNode head) {
    ListNode pointer = head;
    ListNode reversed = null;
    while(pointer!=null){
      ListNode node = new ListNode(pointer.val);
      node.next = reversed;
      reversed = node;
      pointer = pointer.next;
    }
    return reversed;
  }
}