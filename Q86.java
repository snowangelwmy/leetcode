/**
 * Test cases:
 * 1: Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null) {
            return null;
        }

        ListNode lessHead = null;
        ListNode eGreaterHead = null;
        ListNode pointer = head;
        ListNode lessPointer = null;
        ListNode eGreaterPointer = null;
        while(pointer!=null) {
            int value = pointer.val;
            if(value<x) {
                if(lessPointer==null) {
                    lessPointer=pointer;
                    lessHead = lessPointer;
                } else {
                    lessPointer.next = pointer;
                    lessPointer = pointer;
                }
            } else { //value>=x
                if(eGreaterPointer==null) {
                    eGreaterPointer=pointer;
                    eGreaterHead = eGreaterPointer;
                } else {
                    eGreaterPointer.next = pointer;
                    eGreaterPointer = pointer;
                }
            }
            pointer = pointer.next;
            if(lessPointer!=null) {
                lessPointer.next = null;
            }
            if(eGreaterPointer!=null) {
                eGreaterPointer.next = null;
            }
        }
        if(lessHead==null) {
            return eGreaterHead;
        }
        pointer = lessHead;
        while(pointer!=null&&pointer.next!=null) {
            pointer = pointer.next;
        }
        pointer.next = eGreaterHead;
        return lessHead;
    }
}