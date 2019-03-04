/**
 * Test cases:
 * 1: Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;

class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val-node2.val;
            }
        });

        ListNode head, pointer;
        head = pointer = new ListNode(0);
        for(ListNode node : lists) {
            if(node!=null) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            pointer.next = queue.poll();
            pointer = pointer.next;
            if(pointer.next!=null) {
                queue.add(pointer.next);
            }
        }

        return head.next;
    }
}