/**
 * Test cases:
 * 1: Input: head = 1 -> 2 -> -3 -> 3 -> 1
 * Output: 3 -> 1
 * Note: The answer 1 -> 2 -> 1 would also be accepted.
 * 2: Input: head = 1 -> 2 -> 3 -> -3 -> 4
 * Output: 1 -> 2 -> 4
 * 3: Input: head = 1 -> 2 -> 3 -> -3 -> -2
 * Output: 1
 * 4: Input: head = 2 -> 2 -> -2 -> 1 -> -1 -> -1
 * Output: 2 -> -1
 * 5: Input: head = 1 -> 3 -> 2 -> -3 -> -2 -> 5 -> 5 -> -5 -> 1
 * Output: 1 -> 5 -> 1
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

class Q1171 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode removeZeroSumSublists(ListNode head) {
    if(head==null) {
      return null;
    }

    ListNode newHead = head;
    Map<Integer, ListNode> lookup = new HashMap<>();
    int sum = 0;
    ListNode pointer = head;
    while(pointer!=null) {
      sum += pointer.val;
      if(sum==0) {
        newHead = pointer.next;
        lookup.clear();
        pointer = pointer.next;
      } else if(lookup.containsKey(sum)){
        lookup.get(sum).next = pointer.next;
        lookup.clear();
        sum = 0;
        pointer = newHead;
      } else {
        lookup.put(sum, pointer);
        pointer = pointer.next;
      }
    }
    return newHead;
  }
}