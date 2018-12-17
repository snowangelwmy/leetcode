/**
 * Test cases:
 * 1: Input: [3,2,3]
 * Output: 3
 * 2: Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 3: Input: [1]
 *  Output: 1
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int majorityElement2(int[] nums) {
        if(nums==null||nums.length==0){
            return Integer.MIN_VALUE;
        }

        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement1(int[] nums) {
        if(nums==null||nums.length==0){
            return Integer.MIN_VALUE;
        }

        Map<Integer, Integer> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int count;
            if(lookup.containsKey(nums[i])){
                count = lookup.get(nums[i])+1;
            } else {
                count = 1;
            }
            if(count>nums.length/2){
                return nums[i];
            }
            lookup.put(nums[i], count);
        }

        return Integer.MIN_VALUE;
    }
}