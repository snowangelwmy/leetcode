/**
 * Test cases:
 * 1: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 2: Input: (5) + (5)
 * Output: 0 -> 1
 * Explanation: 5 + 5 = 10.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        ListNode l1Pointer = l1, l2Pointer = l2;
        ListNode head = null, pointer = null;
        int sum = 0, addOne = 0;
        while(l1Pointer!=null && l2Pointer!=null) {
            sum = (l1Pointer.val + l2Pointer.val + addOne)%10;
            addOne = (l1Pointer.val + l2Pointer.val + addOne)/10;
            ListNode node = new ListNode(sum);
            if(pointer==null) {
                head = node;
                pointer = node;
            } else {
                pointer.next = node;
                pointer = pointer.next;
            }
            l1Pointer = l1Pointer.next;
            l2Pointer = l2Pointer.next;
        }
        while(l1Pointer!=null) {
            sum = (l1Pointer.val + addOne)%10;
            addOne = (l1Pointer.val + addOne)/10;
            ListNode node = new ListNode(sum);
            pointer.next = node;
            pointer = pointer.next;
            l1Pointer = l1Pointer.next;
        }
        while(l2Pointer!=null) {
            sum = (l2Pointer.val + addOne)%10;
            addOne = (l2Pointer.val + addOne)/10;
            ListNode node = new ListNode(sum);
            pointer.next = node;
            pointer = pointer.next;
            l2Pointer = l2Pointer.next;
        }
        if(addOne>0) {
            ListNode node = new ListNode(addOne);
            pointer.next = node;
            pointer = pointer.next;
        }
        return head;
    }
}