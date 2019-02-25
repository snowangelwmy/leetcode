/**
 * Test cases:
 * 1: Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 2: Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 */

class Q162 {
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }
}