/**
 * Test cases:
 * 1: Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * 2: Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 */

class Q747 {
    public int dominantIndex(int[] nums) {
        if(nums==null||nums.length==0) {
            return -1;
        }

        if(nums.length==0) {
            return nums[0];
        }

        int maxNumIndex = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]>nums[maxNumIndex]) {
                maxNumIndex = i;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(i!=maxNumIndex && nums[maxNumIndex]<2*nums[i]) {
                return -1;
            }
        }

        return maxNumIndex;
    }
}