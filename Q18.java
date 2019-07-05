/**
 * Test cases:
 * 1: Input: Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * Output:
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Q18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> results = new ArrayList<>();
    if(nums==null||nums.length<4) {
      return results;
    }

    Arrays.sort(nums);

    //additional condition checks to see if we could exit earlier
    if(nums[0]+nums[1]+nums[2]+nums[3]>target || nums[nums.length-4]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target) {
      return results;
    }

    int len_1 = nums.length-1;
    int len_2 = nums.length-2;
    int len_3 = nums.length-3;
    int last_numi = nums[0]-1;//initial dummy value
    for(int i=0; i<len_3; i++) {
      if(nums[i]==last_numi) continue;
      last_numi = nums[i];
      int last_numj = nums[0]-1;//initial dummy value
      for(int j=i+1; j<len_2; j++) {
        if(nums[j]==last_numj) continue;
        last_numj = nums[j];

        //additional condition checks to see if we could exit earlier
        if(nums[j+1]+nums[j+2]>target-nums[i]-nums[j]||nums[len_1]+nums[len_2]<target-nums[i]-nums[j]) continue;

        int low = j+1;
        int high = len_1;
        while(low<high) {
          int curSum = nums[i]+nums[j]+nums[low]+nums[high];
          if(curSum==target) {
            Integer[] quadruplets = new Integer[] {nums[i], nums[j], nums[low], nums[high]};
            results.add(Arrays.asList(quadruplets));
            low++;
            high--;
            while(low-1>=j+1 && nums[low]==nums[low-1] && low<high) low++;
            while(high+1<=len_1 && nums[high]==nums[high+1] && low<high) high--;
          } else if(curSum<target) {
            low++;
          } else {//curSum>target
            high--;
          }
        }
      }
    }

    return results;
  }
}
