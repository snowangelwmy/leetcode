/**
 * Test cases:
 * 1: Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 * 2: Input: nums = [-2147483647,0,-2147483647,2147483647], lower = -564, upper = 3864,
 * Output: 3
 */

class Q327 {
    //O(n^2) solution
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        //use long instead of int here to avoid integer overflow
        long[] prefixSums = new long[nums.length+1];
        prefixSums[0] = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSums[i+1] = nums[i] + prefixSums[i];
        }

        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                long curSum = prefixSums[j+1]-prefixSums[i+1]+nums[i];
                if(curSum>=lower&&curSum<=upper) {
                    count++;
                }
            }
        }
        return count;
    }
}