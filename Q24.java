/**
 * Test cases:
 * 1: Input & Output:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 2: Input & Output:
 * Given 1, you should return the list as 1.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q24 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode swapPairs(ListNode head) {
    if(head==null||head.next==null) {
      return head;
    }

    ListNode newHeader = null;
    ListNode previous = null;
    ListNode pointer = head;
    ListNode pointer1 = null;
    ListNode pointer2 = null;
    while(pointer!=null&&pointer.next!=null) {
      pointer1 = pointer;
      pointer2 = pointer.next;
      pointer = pointer2.next;
      //swap pointers
      pointer1.next = pointer2.next;
      pointer2.next = pointer1;
      if(newHeader==null) {
        newHeader = pointer2;
      }
      if(previous!=null) {
        previous.next = pointer2;
      }
      previous = pointer1;
    }
    return newHeader;
  }
}