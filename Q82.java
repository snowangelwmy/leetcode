/**
 * Test cases:
 * 1: Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 2: Input: 1->1->1->2->3
 * Output: 2->3
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Map;
import java.util.HashMap;

class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        Map<Integer, Integer> lookup = new HashMap<>();
        ListNode pointer = head;
        while(pointer!=null) {
            int value = pointer.val;
            if(!lookup.containsKey(value)) {
                lookup.put(value, 0);
            }
            lookup.put(value, lookup.get(value)+1);
            pointer = pointer.next;
        }
        ListNode newHead = head;
        ListNode previous = null;
        pointer = head;
        while(pointer!=null) {
            int value = pointer.val;
            if(lookup.get(value)>1) {
                if(previous!=null) {
                    previous.next = pointer.next;
                } else {
                    newHead = pointer.next;
                }
            } else {
                previous = pointer;
            }
            pointer = pointer.next;
        }
        return newHead;
    }
}