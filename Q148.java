/**
 * Test cases:
 * 1: Input: 4->2->1->3
 * Output: 1->2->3->4
 * 2: Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q148 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode sortList(ListNode head) {
    // only 0 or 1 node in the list
    if(head==null||head.next==null) {
      return head;
    }

    ListNode fast = head;
    ListNode slow = null;
    while(fast!=null&&fast.next!=null) {
      if(slow==null) {
        slow = head;
      } else {
        slow = slow.next;
      }
      fast = fast.next.next;
    }
    ListNode midHead = slow.next;
    slow.next = null;
    ListNode firstHalf = sortList(head);
    ListNode secondHalf = sortList(midHead);
    ListNode newHead = mergeList(firstHalf, secondHalf);
    return newHead;
  }

  private ListNode mergeList(ListNode firstHead, ListNode secondHead) {
    if(firstHead==null) {
      return secondHead;
    }
    if(secondHead==null) {
      return firstHead;
    }
    //fistHead!=null && secondHead!=null
    ListNode newHead = null;
    ListNode pointer = null;
    ListNode pointer1 = firstHead;
    ListNode pointer2 = secondHead;
    while(pointer1!=null && pointer2!=null) {
      if(pointer1.val<=pointer2.val) {
        ListNode temp = pointer1.next;
        pointer1.next = null;
        if(newHead==null) {
          newHead = pointer1;
        } else {
          pointer.next = pointer1;
        }
        pointer = pointer1;
        pointer1 = temp;
      } else {//pointer1.val>pointer2.val
        ListNode temp = pointer2.next;
        pointer2.next = null;
        if(newHead==null) {
          newHead = pointer2;
        } else {
          pointer.next = pointer2;
        }
        pointer = pointer2;
        pointer2 = temp;
      }
    }
    if(pointer1!=null) {
      pointer.next = pointer1;
    } else if(pointer2!=null) {
      pointer.next = pointer2;
    }
    return newHead;
  }
}