/**
 * Test cases:
 * 1: Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if(head==null){
      return head;
    }

    ListNode newHead = head;
    ListNode previous = null;
    ListNode pointer = head;
    while(pointer!=null){
      if(pointer.val==val){
        if(previous==null){
          newHead = pointer.next;
        } else {
          previous.next = pointer.next;
        }
      } else {
        previous = pointer;
      }
      pointer = pointer.next;
    }

    return newHead;
  }
}