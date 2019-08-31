/**
 * Test cases:
 * 1: Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * 2: Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q328 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode oddEvenList(ListNode head) {
    if(head==null||head.next==null) {
      return head;
    }
    ListNode oddHeader = head;
    ListNode evenHeader = head.next;
    ListNode oddTail = head;
    ListNode evenTail = head.next;
    ListNode pointer = head.next.next;
    while(pointer!=null) {
      oddTail.next = pointer;
      oddTail = oddTail.next;

      evenTail.next = pointer.next;
      evenTail = evenTail.next;

      if(pointer.next!=null) {
        pointer = pointer.next.next;
        evenTail.next = null;
      } else {
        pointer = null;
      }

      oddTail.next = null;
    }
    oddTail.next = evenHeader;
    return oddHeader;
  }
}