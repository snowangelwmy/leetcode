/**
 * Test cases:
 * 1: Input: nums = [3,2,2,3], val = 3,, Output: 2
 * 2: Input: nums = [0,1,2,2,3,0,4,2], val = 2, Output: 5
 * 3: Input: nums = [1,2,3,4], val = 5, Output: 4
 * 4: Input: nums = [1,1,1,1], val = 1, Output: 0
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length<=0){
            return 0;
        }

        int length = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                length++;
                continue;
            }

            //nums[i]==val
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]!=val){
                    swap(nums, i, j);
                    length++;
                    break;
                }
            }
        }

        return length;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}