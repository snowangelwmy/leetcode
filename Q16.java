/**
 * Test cases:
 * 1: Input: Given array nums = [-1, 2, 1, -4], and target = 1.
 * Output: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 2: Input: [-3,-2,-5,3,-4], and target = -1.
 * Output: The sum that is closest to the target is -2. (-3 - 2 + 3 = -2).
 */

import java.util.Arrays;

class Q16 {
  public int threeSumClosest(int[] nums, int target) {
    if(nums==null || nums.length<3) {
      return Integer.MAX_VALUE;
    }
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[nums.length-1];
    for(int i=0; i<nums.length-2; i++) {
      int low = i+1;
      int high = nums.length-1;
      while(low<high) {
        int curSum = nums[i] + nums[low] + nums[high];
        if(curSum==target) {
          return target;
        } else if(curSum>target) {
          high--;
        } else {//curSum<target
          low++;
        }
        if(Math.abs(curSum-target)<Math.abs(result-target)) { //be careful about integer overflow
          result = curSum;
        }
      }
    }
    return result;
  }
}