/**
 * Test cases:
 * 1: // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Random;

class Q382 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode head;
    private int count;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Q382(ListNode head) {
        this.head = head;
        this.count = 0;
        this.random = new Random();
        ListNode pointer = head;
        while(pointer!=null) {
            count++;
            pointer = pointer.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = random.nextInt(count);
        ListNode pointer = head;
        while(index>0) {
            pointer = pointer.next;
            index--;
        }
        return pointer.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */