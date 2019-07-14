/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) {
            return head;
        }

        int count = 0;
        ListNode fastPointer = head;
        while(count<k) {
            fastPointer = fastPointer.next;
            if(fastPointer==null) {
                fastPointer=head;
            }
            count++;
        }

        ListNode slowPointer = head;
        while(fastPointer.next!=null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        ListNode newHead = null;
        if(fastPointer!=slowPointer) {
            newHead = slowPointer.next;
            fastPointer.next = head;
            slowPointer.next = null;
        } else { //k is a multiple of the length of the list, so rotated the whole list
            newHead = head;
        }

        return newHead;
    }
}