/**
 * Test cases:
 * 1: Input: root = [1 -> 2 -> 3 -> null], k = 5
 * Output: [[1 -> null],[2 -> null],[3 -> null], [null], [null]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * 2: Input: root = [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10], k = 3
 * Output: [[1 -> 2 -> 3 -> 4 -> null], [5 -> 6 -> 7 -> null], [8 -> 9 -> 10 -> null]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q725 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] result = new ListNode[k];
    for(int i=0; i<k; i++) {
      result[i] = null;
    }

    if(root==null) {
      return result;
    }

    int total = 0;
    ListNode pointer = root;
    while(pointer!=null) {
      total++;
      pointer = pointer.next;
    }
    int numOfNodes = total/k;
    int numOfParts = total%k;

    pointer = root;
    for(int i=0; i<k; i++) {
      ListNode head = null;
      ListNode next = null;
      for(int j=0; j<numOfNodes; j++) {
        if(j==0) {
          head = pointer;
        }
        next = pointer;
        pointer = pointer.next;
      }
      if(i<numOfParts) {
        if(head==null) {
          head = pointer;
        }
        next = pointer;
        pointer = pointer.next;
      }
      if(next!=null) {
        next.next = null;
      }
      result[i] = head;
    }
    return result;
  }
}