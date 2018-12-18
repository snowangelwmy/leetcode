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
class Solution {
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