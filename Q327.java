/**
 * Test cases:
 * 1: Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 * 2: Input: nums = [-2147483647,0,-2147483647,2147483647], lower = -564, upper = 3864,
 * Output: 3
 */

import java.util.TreeMap;

class Q327 {
    //O(n) solution
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        TreeMap<Long, Integer> lookup = new TreeMap<>();
        lookup.put(0L, 1);

        int totalCount = 0;
        long prefixSum = 0L;
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            for(int count : lookup.subMap(prefixSum-upper, true, prefixSum-lower, true).values()) {
                totalCount += count;
            }
            lookup.put(prefixSum, lookup.getOrDefault(prefixSum, 0)+1);
        }
        return totalCount;
    }

    //O(n^2) solution
    public int countRangeSum0(int[] nums, int lower, int upper) {
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