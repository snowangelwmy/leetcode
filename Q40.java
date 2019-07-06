/**
 * Test cases:
 * 1: Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * Output: A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 2: Input: candidates = [2,5,2,1,2], target = 5,
 * Output: A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.lang.StringBuilder;

class Q40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    if(candidates==null||candidates.length==0) {
      return results;
    }
    List<Integer> nums = new ArrayList<>();
    comSum2Helper(results, nums, 0, 0, candidates, target);
    return removeDuplicate(results);
  }

  private void comSum2Helper(List<List<Integer>> results, List<Integer> nums, int index, int sum, int[] candidates, int target) {
    if(sum>target) {
      return;
    } else if(sum==target) {
      List<Integer> result = new ArrayList<>(nums);
      results.add(result);
      return;
    }

    for(int i=index; i<candidates.length; i++) {
      nums.add(candidates[i]);
      comSum2Helper(results, nums, i+1, sum+candidates[i], candidates, target);
      nums.remove(nums.size()-1);
    }
  }

  private List<List<Integer>> removeDuplicate(List<List<Integer>> results) {
    List<List<Integer>> newResults = new ArrayList<>();
    Set<String> lookup = new HashSet<>();
    for(List<Integer> result : results) {
      Collections.sort(result);
      StringBuilder hashCode = new StringBuilder();
      for(Integer num : result) {
        hashCode.append(num + ",");
      }
      if(lookup.contains(hashCode.toString())) continue;
      lookup.add(hashCode.toString());
      newResults.add(result);
    }
    return newResults;
  }
}