/**
 * Test cases:
 * 1: Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Q506 {
    public String[] findRelativeRanks(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        String[] ranks = new String[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            if(i==nums.length-1) {
                ranks[i] = "Gold Medal";
            } else if(i==nums.length-2) {
                ranks[i] = "Silver Medal";
            } else if(i==nums.length-3) {
                ranks[i] = "Bronze Medal";
            } else {
                ranks[i] = ""+ (nums.length - i);
            }
        }
        Map<Integer, String> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            lookup.put(newNums[i], ranks[i]);
        }

        String[] result = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = lookup.get(nums[i]);
        }

        return result;
    }
}