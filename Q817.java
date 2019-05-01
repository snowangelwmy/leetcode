/**
 * Test cases:
 * 1: Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * 2: Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.HashSet;

class Q817 {
    public int numComponents(ListNode head, int[] G) {
        if(head==null||G==null||G.length==0) {
            return 0;
        }

        HashSet<Integer> gValues = new HashSet<Integer>();
        for(int i=0; i<G.length; i++) {
            gValues.add(G[i]);
        }

        int num = 0;
        ListNode pointer = head;
        while(pointer!=null) {
            if(gValues.contains(pointer.val) && (pointer.next==null || !gValues.contains(pointer.next.val))) {
                num++;
            }
            pointer = pointer.next;
        }
        return num;
    }
}