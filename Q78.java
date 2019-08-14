/**
 * Test cases:
 * 1: Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = subsetsHelper(nums, 0, nums.length-1);
        return result;
    }

    private List<List<Integer>> subsetsHelper(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        if(start>end) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        //start<=end
        List<List<Integer>> subsetResult = subsetsHelper(nums, start+1, end);
        result.addAll(subsetResult);
        for(List<Integer> curSubset : subsetResult) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(curSubset);
            newSubset.add(nums[start]);
            result.add(newSubset);
        }
        return result;
    }
}