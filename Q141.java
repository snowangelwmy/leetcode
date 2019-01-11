/**
 * Test cases:
 * 1: Input: head = [3,2,0,-4], pos = 1
 * 3->2->0->-4
 * ^_________|
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * 2: Input: head = [1,2], pos = 0
 * 1->2
 * ^__|
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * 3: Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.Map;
import java.util.HashMap;

public class Q141 {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public boolean hasCycle2(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer!=null&&fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer==slowPointer) {
                return true;
            }
        }

        return false;
    }


    //using non-constant memory
    public boolean hasCycle1(ListNode head) {
        int pos = -1;
        ListNode pointer = head;
        Map<ListNode, Integer> lookup = new HashMap<>();
        int index = 0;
        while(pointer!=null){
            if(lookup.containsKey(pointer)){
                pos = lookup.get(pointer);
                return true;
            }

            lookup.put(pointer, index);
            index++;
            pointer = pointer.next;
        }

        return false;
    }
}