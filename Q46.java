/**
 * Test cases:
 * 1: Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return results;
        }

        permuteHelper(nums, 0, results);
        return results;
    }

    private void permuteHelper(int[] nums, int index, List<List<Integer>> results) {
        if(index==nums.length) {
            List<Integer> result = new ArrayList<>(nums.length);
            for(int num: nums) {
                result.add(num);
            }
            results.add(result);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            permuteHelper(nums, index+1, results);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute0(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return results;
        }

        permuteHelper(results, nums, new ArrayList<Integer>());
        return results;
    }

    private void permuteHelper(List<List<Integer>> results, int[] left, List<Integer> current) {
        if(left.length==0) {
            results.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i=0; i<left.length; i++) {
            current.add(left[i]);
            int[] newLeft = new int[left.length-1];
            int idx = 0;
            for(int j=0; j<left.length; j++) {
                if(j!=i) {
                    newLeft[idx++] = left[j];
                }
            }
            permuteHelper(results, newLeft, current);
            current.remove(current.size()-1);
        }
    }
}