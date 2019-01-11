/**
 * Test cases:
 * 1: Input: 1->2
 * Output: false
 * 2: Input: 1->2->2->1
 * Output: true
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Stack;

class Q234 {

  public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }

  public boolean isPalindrome(ListNode head) {
    int length = 0;
    ListNode pointer = head;
    while(pointer!=null){
      length++;
      pointer = pointer.next;
    }

    int offset = (length+1)/2;
    ListNode fastPointer = head;
    int count = 0;
    Stack<Integer> firstHalfNums = new Stack<>();
    while(count<offset){
      if(length%2==0||count!=offset-1){
        firstHalfNums.push(fastPointer.val);
      }
      fastPointer = fastPointer.next;
      count++;
    }
    while(fastPointer!=null){
      if(fastPointer.val!=firstHalfNums.pop()){
        return false;
      }
      fastPointer = fastPointer.next;
    }
    return true;
  }
}