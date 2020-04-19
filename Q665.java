/**
 * Test cases:
 * 1: Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * 2: Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * 3: Input: nums = [1,2,4,1,2,3]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * 4: Input: nums = [1,2,4,1,6,7]
 * Output: true
 * Explanation: You could modify the second 1 to 5 to get a non-decreasing array.
 */

import java.util.Set;
import java.util.HashSet;

class Q665 {
    public boolean checkPossibility(int[] nums) {
        if(nums==null||nums.length<3) {
            return true;
        }

        Set<Integer> indexes = new HashSet<>();
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) {
                if(i>0) {
                    if(nums[i-1]>nums[i+1]) {
                        indexes.add(i+1);
                    } else {
                        indexes.add(i);
                    }
                } else {
                    indexes.add(i);
                }

                if(indexes.size()>1) {
                    return false;
                }
            }
        }

        if(indexes.isEmpty()) {
            return true;
        }

        int index = indexes.iterator().next();
        if(index==0||index==nums.length-1) {
            return true;
        }

        if(nums[index-1]>nums[index+1]) {
            return false;
        }

        return true;
    }
}