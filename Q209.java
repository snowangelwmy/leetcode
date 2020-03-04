/**
 * Test cases:
 * 1: Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */

class Q209 {
    //https://leetcode.com/problems/minimum-size-subarray-sum/solution/
    //Approach 3: Using 2 pointers, Time complexity: O(n)O(n).
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum>=s) {
                minLen = Math.min(minLen, i-start+1);
                sum -= nums[start++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //Approach #2: Using Binary search, Time complexity: O(nlog(n)).
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int[] sums = new int[nums.length];
        int sum = 0;
        sums[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<sums.length; i++) {
            int target = s+sums[i]-nums[i];
            int smallIdex = getSmallestIndex(sums, i, target);
            System.out.println("smallIdex: " + smallIdex);
            if(smallIdex!=-1) {
                minLen = Math.min(minLen, smallIdex-i+1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int getSmallestIndex(int[] sums, int start, int target) {
        int end = sums.length-1;
        int smallIndex = -1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(sums[mid]==target) {
                return mid;
            } else if(sums[mid]<target) {
                start = mid+1;
            } else {//sums[mid]>target
                smallIndex = mid;
                end = mid - 1;
            }
        }

        return smallIndex;
    }

    //Approach #1: A better brute force, Time complexity: O(n^2).
    public int minSubArrayLen0(int s, int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int[] sums = new int[nums.length];
        int sum = 0;
        sums[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<sums.length; i++) {
            for(int j=i; j<sums.length; j++) {
                if(sums[j]-sums[i]+nums[i]>=s) {
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}