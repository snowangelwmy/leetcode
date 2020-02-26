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
    //O(n) extra space
    public int findDuplicate(int[] nums) {
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