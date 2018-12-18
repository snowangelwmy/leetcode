/**
 * Test cases:
 * 1: Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 2: Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 3: Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if(nums==null||nums.length==0){
      return false;
    }
    Map<Integer, List<Integer>> lookup = new HashMap<>();
    for(int i=0; i<nums.length; i++){
      Integer num = Integer.valueOf(nums[i]);
      if(lookup.containsKey(num)){
        List<Integer> indices = lookup.get(num);
        for(int j=0; j<indices.size(); j++){
          if(i-indices.get(j)<=k){
            return true;
          }
        }
        indices.add(i);
      } else {//!lookup.containsKey(num)
        List<Integer> indices = new ArrayList<>();
        indices.add(i);
        lookup.put(num, indices);
      }
    }

    return false;
  }
}