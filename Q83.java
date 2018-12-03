/**
 * Test cases:
 * 1: Input: 1->1->2, Output: 1->2
 * 2: Input: 1->1->2->3->3, Output: 1->2->3
 */

import java.util.Set;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode pointer=head;
        int num = pointer.val;
        while(pointer!=null && pointer.next!=null){
            if(num == pointer.next.val){
                pointer.next = pointer.next.next;
            } else {
                num = pointer.next.val;
                pointer = pointer.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates0(ListNode head) {
        if(head==null){
            return head;
        }

        Set<Integer> lookup = new HashSet<>();
        lookup.add(head.val);
        ListNode pointer=head;
        while(pointer!=null && pointer.next!=null){
            if(lookup.contains(pointer.next.val)){
                pointer.next = pointer.next.next;
            } else {
                lookup.add(pointer.next.val);
                pointer = pointer.next;
            }
        }

        return head;
    }
}