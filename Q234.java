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

  //O(n) time and O(1) space
  public boolean isPalindrome(ListNode head) {
    if(head==null) {
      return true;
    }

    if(head!=null&&head.next==null) {
      return true;
    }

    ListNode fast = head;
    ListNode slow = head;
    while(fast!=null&&fast.next!=null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode reverse = reverseList(slow);
    slow = head;
    while(slow!=null && reverse!=null) {
      if(slow.val!=reverse.val) {
        return false;
      }
      slow = slow.next;
      reverse = reverse.next;
    }
    return true;
  }

  private ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while(cur!=null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }

  public boolean isPalindrome0(ListNode head) {
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