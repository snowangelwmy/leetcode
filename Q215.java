/**
 * Test cases:
 * 1: Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 2: Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */

import java.util.Arrays;
import java.util.Collections;

class Q215 {
    public int findKthLargest(int[] nums, int k) {
        Integer[] newNums = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums, Collections.reverseOrder());
        return newNums[k-1];
    }
}