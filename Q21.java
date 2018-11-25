/**
 * Test cases:
 * 1: Input: 1->2->4, 1->3->4, Output: 1->1->2->3->4->4
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        } else if(l2==null) {
            return l1;
        }

        ListNode l = null;
        ListNode pointer = null;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while(pointer1!=null&&pointer2!=null){
            if(pointer1.val>=pointer2.val){
                if(pointer==null){
                    l=pointer=pointer2;
                } else {
                    pointer.next=pointer2;
                    pointer=pointer.next;
                }
                pointer2=pointer2.next;
            } else {//pointer1.val<pointer2.val
                if(pointer==null){
                    l=pointer=pointer1;
                } else {
                    pointer.next=pointer1;
                    pointer=pointer.next;
                }
                pointer1=pointer1.next;
            }
        }

        if(pointer1!=null){
            pointer.next=pointer1;
        } else {//pointer2!=null
            pointer.next=pointer2;
        }

        return l;
    }
}