/**
 * Test cases:
 * 1: Input: [1,2,3,1]
 * Output: true
 * 2: Input: [1,2,3,4]
 * Output: false
 * 3: Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Q217 {

  public boolean containsDuplicate(int[] nums) {
    if(nums==null||nums.length==0) {
      return false;
    }

    Set<Integer> seen = new HashSet<>();
    for(int num : nums) {
      if(seen.contains(num)) {
        return true;
      }
      seen.add(num);
    }

    return false;
  }

  public boolean containsDuplicate0(int[] nums) {
    if(nums==null||nums.length==0){
      return false;
    }

    Map<Integer, Boolean> lookup = new HashMap<>();
    for(int i=0; i<nums.length; i++){
      Integer num = Integer.valueOf(nums[i]);
      if(lookup.containsKey(num)){
        return true;
      }
      lookup.put(num, true);
    }

    return false;
  }
}