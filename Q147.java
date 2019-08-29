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
class Q147 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode insertionSortList(ListNode head) {
    if(head==null) {
      return null;
    }

    ListNode nextNode = head.next;
    head.next = null;
    ListNode newHead = head;
    while(nextNode!=null) {
      ListNode tempNode = nextNode.next;
      newHead = insertNode(nextNode, newHead);
      nextNode = tempNode;
    }
    return newHead;
  }

  private ListNode insertNode(ListNode node, ListNode head) {
    if(node.val<=head.val) {
      node.next = head;
      return node;
    }
    //node.val>head.val
    ListNode previous = head;
    ListNode current = head.next;
    while(current!=null&&current.val<node.val) {
      previous = current;
      current = current.next;
    }
    if(current==null) {
      previous.next = node;
      node.next = null;
    } else {
      node.next = current;
      previous.next = node;
    }
    return head;
  }
}