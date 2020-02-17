/**
 * Test cases:
 * 1: Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 2: Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

import java.util.List;
import java.util.ArrayList;

class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinationSum3Helper(nums, 0, k, n, result, new ArrayList<Integer>());
        return result;
    }

    private void combinationSum3Helper(int[] nums, int index, int k, int n, List<List<Integer>> result, List<Integer> numsList) {
        if(k==0) {
            int sum = 0;
            for(int num : numsList) {
                sum += num;
            }
            if(sum==n) {
                result.add(new ArrayList<Integer>(numsList));
            }
            return;
        }

        for(int i=index; i<=nums.length-k; i++) {
            numsList.add(nums[i]);
            combinationSum3Helper(nums, i+1, k-1, n, result, numsList);
            numsList.remove(numsList.size()-1);
        }
    }
}