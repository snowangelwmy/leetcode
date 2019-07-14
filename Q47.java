/**
 * Test cases:
 * 1: Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if(nums==null||nums.length==0) {
      return results;
    }

    permuteUniqueHelper(nums, 0, results);
    return results;
  }

  private void permuteUniqueHelper(int[] nums, int index, List<List<Integer>> results){
    if(index>=nums.length) {
      List<Integer> result = new ArrayList<>();
      for(int num: nums) {
        result.add(num);
      }
      results.add(result);
      return;
    }

    Set<Integer> seen = new HashSet<>();
    for(int i=index; i<nums.length; i++) {
      if(seen.contains(nums[i])) continue;
      seen.add(nums[i]);
      swap(nums, index, i);
      permuteUniqueHelper(nums, index+1, results);
      swap(nums, index, i);
    }
  }

  private void swap(int[] nums, int i, int j) {
    if(i!=j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}