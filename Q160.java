/**
 * Test cases:
 * 1:
 * A:    4->1->
 *             8->4->5
 * B: 5->0->1->
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * 2:
 * A: 0->9->1->
 *             2->4
 * B:       3->
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * 3:
 * A: 2->6->4
 * B: 1->5
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }

        //headA!=null&&headB!=null
        int lengthA = 1;
        ListNode tailA = headA;
        while(tailA.next!=null){
            lengthA++;
            tailA = tailA.next;
        }

        int lengthB = 1;
        ListNode tailB = headB;
        while(tailB.next!=null){
            lengthB++;
            tailB = tailB.next;
        }

        if(tailA!=tailB){
            return null;
        }

        if(lengthA>=lengthB){
            return getIntersectionNode(headA, headB, lengthA, lengthB);
        } else {
            return getIntersectionNode(headB, headA, lengthB, lengthA);
        }
    }

    private ListNode getIntersectionNode(ListNode longerHead, ListNode shorterHead, int longerLength, int shorterLength) {
        ListNode longerPointer = longerHead;
        for(int i=0; i<longerLength-shorterLength; i++){
            longerPointer = longerPointer.next;
        }
        ListNode shorterPointer = shorterHead;
        while(longerPointer!=shorterPointer){
            longerPointer = longerPointer.next;
            shorterPointer = shorterPointer.next;
        }

        return shorterPointer;
    }
}