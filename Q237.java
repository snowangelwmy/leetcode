/**
 * Test cases:
 * Linked list: 4 -> 5 -> 1 -> 9
 * 1: Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list
 *              should become 4 -> 1 -> 9 after calling your function.
 * 2: Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list
 *              should become 4 -> 5 -> 9 after calling your function.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q237 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public void deleteNode(ListNode node) {
    if(node==null){
      return;
    }
    ListNode previous = node;
    ListNode current = node.next;
    if(current==null){
      System.out.println("The node to be deleted is the tail node.");
      return;
    }
    while(current!=null) {
      previous.val = current.val;
      //reset the tail pointer
      if(current.next==null){
        previous.next = null;
      }
      previous = current;
      current = current.next;
    }
  }
}