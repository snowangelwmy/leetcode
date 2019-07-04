/**
 * Test cases:
 * 1: Input: Given array nums = [-1, 0, 1, 2, -1, -4],
 * Output: A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<3) {
            return res;
        }

        Arrays.sort(nums);
        Map<Integer, Integer> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            lookup.put(nums[i], i);
        }

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                int target = 0 - nums[i] - nums[j];
                if(lookup.containsKey(target) && lookup.get(target)>j) {
                    Integer[] triplet = new Integer[] {nums[i], nums[j], target};
                    res.add(Arrays.asList(triplet));
                }
                j=lookup.get(nums[j]);
            }
            i=lookup.get(nums[i]);
        }
        return res;
    }
}