/**
 * Test cases:
 * 1: Input: Given linked list: 1->2->3->4->5, and n = 2.
 * Output: After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q19 {

  public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

  //one pass approach
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode pointer1 = head;
    while(pointer1!=null&&count<n+1) {
      count++;
      pointer1 = pointer1.next;
    }
    if(count<n) {
      return head;
    } else if(count==n) {
      return head.next;
    }

    //count=n+1
    ListNode pointer2 = head;
    while(pointer1!=null) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }
    pointer2.next = pointer2.next.next;
    return head;
  }

  //two pass approach
  public ListNode removeNthFromEnd0(ListNode head, int n) {
    int total = 0;
    ListNode pointer = head;
    while(pointer!=null) {
      total++;
      pointer = pointer.next;
    }
    if(total<n) {
      return head;
    } else if(total==n) {
      return head.next;
    }

    //total>n
    pointer = head;
    int i = 1;
    while(i<total-n) {
      pointer = pointer.next;
      i++;
    }
    pointer.next = pointer.next.next;
    return head;
  }
}