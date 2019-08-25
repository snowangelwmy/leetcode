/**
 * Test cases:
 * 1: Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q92 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //one-pass approach.
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode pre = null;
    ListNode cur = head;
    int count = 1;
    while(count<m && cur!=null) {
      count++;
      pre = cur;
      cur = cur.next;
    }

    if(count<m) {
      return head;
    }

    ListNode start = pre;
    ListNode end = cur;
    ListNode third = null;
    while(count<=n && cur!=null) {
      //reverse the list
      third = cur.next;
      cur.next = pre;
      pre = cur;
      cur = third;
      count++;
    }

    if(start!=null) {
      start.next = pre;
    } else {
      head = pre;
    }
    if(end!=null) {
      end.next = cur;
    }
    return head;
  }


  private ListNode left = null;
  private boolean stop = false;

  //two-pass approach. Once during the normal recursion process and once during the backtracking process.
  public ListNode reverseBetween0(ListNode head, int m, int n) {
    this.left = head;
    this.stop = false;
    recursiveAndReverse(head, m, n);
    return head;
  }

  private void recursiveAndReverse(ListNode right, int m, int n) {
    if(n==1) {
      return;
    }

    right = right.next;

    if(m>1) {
      this.left = this.left.next;
    }

    this.recursiveAndReverse(right, m-1, n-1);

    if(this.left == right || right.next == this.left) {
      stop = true;
    }

    if(!stop) {
      int temp = right.val;
      right.val = this.left.val;
      this.left.val = temp;

      this.left = this.left.next;
    }
  }
}