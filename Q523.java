/**
 * Test cases:
 * 1: Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * 2: Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * 3: Input: [23, 2, 4, 6, 7],  k=0
 * Output: False
 */

class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums==null||nums.length<2) {
            return false;
        }

        int[] preSums = new int[nums.length+1];
        preSums[0] = 0;
        for(int i=0; i<nums.length; i++) {
            preSums[i+1] = nums[i] + preSums[i];
        }

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                int curSum = preSums[i+1] - preSums[j];
                if((k==0&&curSum==0)||(k!=0&&curSum%k==0)) {
                    return true;
                }
            }
        }

        return false;
    }
}