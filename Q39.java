/**
 * Test cases:
 * 1: A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 2: Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    if(candidates==null||candidates.length==0) {
      return results;
    }
    List<Integer> nums = new ArrayList<>();
    comSumHelper(results, nums, 0, 0, candidates, target);
    return results;
  }

  private void comSumHelper(List<List<Integer>> results, List<Integer> nums, int index, int sum, int[] candidates, int target) {
    if(sum>target) {
      return;
    } else if(sum==target) {
      List<Integer> result = new ArrayList<>(nums);
      results.add(result);
      return;
    }

    for(int i=index; i<candidates.length; i++) {
      nums.add(candidates[i]);
      comSumHelper(results, nums, i, sum+candidates[i], candidates, target);
      //nums.remove(candidates[i]);//will throw IndexOutOfBoundsException
      nums.remove(nums.size()-1);
    }
  }
}