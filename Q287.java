/**
 * Test cases:
 * 1: Input: [1,3,4,2,2]
 * Output: 2
 * 2: Input: [3,1,3,4,2]
 * Output: 3
 */

import java.util.Set;
import java.util.HashSet;

class Q287 {

    //O(1) space, O(nlog(n)) runtime complexity
    //https://leetcode.com/problems/find-the-duplicate-number/discuss/443011/Accepted-Java-Binary-Search-Solution-(Meet-all-Requirements)
    public int findDuplicate(int[] nums) {
        if(nums==null||nums.length==0) {
            return Integer.MIN_VALUE;
        }

        int low = 0;
        int high = nums.length-1;
        while(low<high) {
            int mid = (low+high)/2;

            int count = 0;
            for(int num : nums) {
                if(num<=mid) {
                    count++;
                }
            }

            if(count>mid) {
                high = mid;
            } else {//count<=mid
                low = mid + 1;
            }
        }

        return low;
    }

    //O(n) extra space
    public int findDuplicate0(int[] nums) {
        if(nums==null||nums.length==0) {
            return Integer.MIN_VALUE;
        }

        Set<Integer> lookup = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(lookup.contains(nums[i])) {
                return nums[i];
            } else {
                lookup.add(nums[i]);
            }
        }

        return Integer.MIN_VALUE;
    }
}