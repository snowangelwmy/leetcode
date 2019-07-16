/**
 * Test cases:
 * 1: Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 2: Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * 3: Input: 1->NULL, k = 0
 * Output: 1->NULL
 * 4: Input: 1->NULL, k = 1
 * Output: 1->NULL
 * 5: Input: 1->2->NULL, k = 2
 * Output: 1->2->NULL
 *
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