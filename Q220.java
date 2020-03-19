/**
 * Test cases:
 * 1: Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 2: Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 3: Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 4: Input: nums = [-1,2147483647], k = 1, t = 2147483647
 * Output: false
 * 5: Input: nums = [0,2147483647], k = 1, t = 2147483647
 * Output: true
 */

import java.util.Map;
import java.util.HashMap;

class Q220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length && j<=i+k; j++) {
                long numI = nums[i];
                long numJ = nums[j];
                long I = i;
                long J = j;
                if(Math.abs(numI-numJ)<=t && Math.abs(I-J)<=k) {
                    return true;
                }
            }
        }

        return false;
    }

    // Time Limit Exceeded
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        Map<Long, Integer> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            Long numI = Long.valueOf(nums[i]);
            int j = 0;
            while(j<=t) {
                if(lookup.containsKey(numI-j) && i-lookup.get(numI-j)<=k) {
                    return true;
                }
                if(lookup.containsKey(numI+j) && i-lookup.get(numI+j)<=k) {
                    return true;
                }
                j++;
            }
            lookup.put(numI, i);
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                long numI = nums[i];
                long numJ = nums[j];
                long I = i;
                long J = j;
                if(Math.abs(numI-numJ)<=t && Math.abs(I-J)<=k) {
                    return true;
                }
            }
        }

        return false;
    }
}