/**
 * Test cases:
 * 1: Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 2: Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 3: Input: nums = [4, 5, 5, 6]
 * Output: One possible answer is [5, 6, 4, 5].
 */

import java.util.Arrays;

class Q324 {
    //https://leetcode.com/problems/wiggle-sort-ii/discuss/332357/Java-Solution
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length<2) {
            return;
        }

        if(nums.length==2) {
            if(nums[0]>nums[1]) {
                swap(nums, 0, 1);
            }
            return;
        }

        int length = nums.length;
        int[] numsCopy = Arrays.copyOf(nums, length);
        Arrays.sort(numsCopy);
        for(int i=0; i<length; i++) {
            nums[(2*i+1)%(length|1)] = numsCopy[length-1-i];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}