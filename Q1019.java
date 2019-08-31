/**
 * Test cases:
 * 1: Input: 2 -> 1 -> 5
 * Output: [5,5,0]
 * 2: Input: 2 -> 7 -> 4 -> 3 -> 5
 * Output: [7,0,5,5,0]
 * 3: Input: 1 -> 7 -> 5 -> 1 -> 9 -> 2 -> 5 -> 1
 * Output: [7,9,9,9,0,5,0,0]
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Q1019 {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  // Stack approach
  public int[] nextLargerNodes(ListNode head) {
    if(head==null) {
      return null;
    }

    List<Integer> nums = new ArrayList<>();
    ListNode pointer = head;
    while(pointer!=null) {
      nums.add(pointer.val);
      pointer = pointer.next;
    }

    int[] ans = new int[nums.size()];
    Stack<Integer> indexes = new Stack<>();
    for(int i=0; i<nums.size(); i++) {
      while(!indexes.isEmpty() && nums.get(indexes.peek()) < nums.get(i)) {
        ans[indexes.pop()] = nums.get(i);
      }
      indexes.push(i);
    }

    return ans;
  }

  // Brute force approach
  public int[] nextLargerNodes0(ListNode head) {
    if(head==null) {
      return null;
    }

    List<Integer> nums = new ArrayList<>();
    ListNode pointer = head;
    while(pointer!=null) {
      nums.add(pointer.val);
      pointer = pointer.next;
    }

    int[] ans = new int[nums.size()];
    for(int i=0; i<nums.size()-1; i++) {
      for(int j=i+1; j<nums.size(); j++) {
        if(nums.get(j)>nums.get(i)) {
          ans[i] = nums.get(j);
          break;
        }
      }
    }

    return ans;
  }
}