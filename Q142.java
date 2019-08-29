/**
 * Test cases:
 * 1: Input: head = [3,2,0,-4], pos = 1
 * 3 -> 2 -> 0 -> -4
 *      ^          |
 *       -----------
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * 2: Input: head = [1,2], pos = 0
 * 1 -> 2
 * ^    |
 * ------
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * 3: Input: head = [1], pos = -1
 * 1
 * Output: no cycle
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

import java.util.Set;
import java.util.HashSet;

public class Q142 {

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
        val = x;
        next = null;
      }
  }

  // Floyd’s Cycle-Finding Algorithm - use two pointers
  public ListNode detectCycle(ListNode head) {
    if(head==null) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;
    boolean hasCycle = false;
    while(fast!=null&&fast.next!=null) {
      slow = slow.next; // move 1 step
      fast = fast.next.next; // move 2 steps
      if(slow==fast) {
        hasCycle = true;
        break;
      }
    }
    if(!hasCycle) {
      return null;
    }

    fast = head;
    while(fast!=slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }


  // use extra space: Set
  // Traverse the list one by one and keep putting the node addresses in a Hash Set.
  // At any point, if NULL is reached then return false
  // and if next of current node points to any of the previously stored nodes in Hash then return true.
  public ListNode detectCycle0(ListNode head) {
    if(head==null) {
      return null;
    }

    Set<ListNode> lookup = new HashSet<>();
    ListNode pointer = head;
    while(pointer!=null) {
      if(lookup.contains(pointer)) {
        return pointer;
      }
      lookup.add(pointer);
      pointer = pointer.next;
    }
    return null;
  }
}