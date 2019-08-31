/**
 * Test cases:
 * 1: Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Stack;

class Q445 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1==null) {
      return l2;
    }
    if(l2==null) {
      return l1;
    }

    //l1!=null && l2!=null
    ListNode pointer1 = l1;
    ListNode pointer2 = l2;
    int count1 = 0;
    int count2 = 0;
    while(pointer1!=null) {
      count1++;
      pointer1 = pointer1.next;
    }
    while(pointer2!=null) {
      count2++;
      pointer2 = pointer2.next;
    }
    if(count1<count2) {
      pointer1 = addZeros(count2-count1, l1);
      pointer2 = l2;
    } else if(count1>count2) {
      pointer2 = addZeros(count1-count2, l2);
      pointer1 = l1;
    } else { //count1==count2
      pointer1 = l1;
      pointer2 = l2;
    }

    Stack<Integer> num1 = new Stack<>();
    Stack<Integer> num2 = new Stack<>();
    while(pointer1!=null) {
      num1.push(pointer1.val);
      pointer1 = pointer1.next;
    }
    while(pointer2!=null) {
      num2.push(pointer2.val);
      pointer2 = pointer2.next;
    }

    ListNode pointer = null;
    int addOn = 0;
    while(!num1.isEmpty() && !num2.isEmpty()) {
      int val1 = num1.pop();
      int val2 = num2.pop();
      int sum = val1+val2+addOn;
      if(sum>=10) {
        sum -= 10;
        addOn = 1;
      } else {
        addOn = 0;
      }
      ListNode node = new ListNode(sum);
      if(pointer==null) {
        pointer = node;
      } else {
        node.next = pointer;
        pointer = node;
      }
    }
    if(addOn==1) {
      ListNode node = new ListNode(1);
      node.next = pointer;
      return node;
    }
    return pointer;
  }

  private ListNode addZeros(int count, ListNode head) {
    ListNode newHead = null;
    ListNode pointer = null;
    for(int i=0; i<count; i++) {
      ListNode node = new ListNode(0);
      if(pointer==null) {
        pointer = node;
        newHead = node;
      } else {
        pointer.next = node;
      }
      pointer = node;
    }
    pointer.next = head;
    return newHead;
  }
}