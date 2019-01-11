/**
 * Test cases:
 * 1: Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Q350 {
  //if the given array is already sorted
  public static int[] intersect2(int[] nums1, int[] nums2) {
    if(nums1==null||nums2==null){
      return null;
    }
    List<Integer> intersection = new ArrayList<>();
    int i = 0;
    int j = 0;
    while(i<nums1.length && j<nums2.length){
      if(nums1[i]<nums2[j]){
        i++;
      } else if(nums1[i]>nums2[j]) {
        j++;
      } else {//nums[i]==nums2[j]
        intersection.add(nums1[i]);
        i++;
        j++;
      }
    }
    int[] result = new int[intersection.size()];
    int idx = 0;
    for(Integer num : intersection) {
      result[idx++] = num;
    }
    return result;
  }

  public int[] intersect1(int[] nums1, int[] nums2) {
    if(nums1==null||nums2==null){
      return null;
    }
    Map<Integer, Integer> nums1Statistics = new HashMap<>();
    for(int i=0; i<nums1.length; i++){
      Integer num = Integer.valueOf(nums1[i]);
      if(!nums1Statistics.containsKey(num)){
        nums1Statistics.put(num, 0);
      }
      nums1Statistics.put(num, nums1Statistics.get(num)+1);
    }
    List<Integer> intersection = new ArrayList<>();
    for(int i=0; i<nums2.length; i++){
      Integer num = Integer.valueOf(nums2[i]);
      if(nums1Statistics.containsKey(num)){
        intersection.add(num);
        int count = nums1Statistics.get(num)-1;
        if(count==0){
          nums1Statistics.remove(num);
        } else {
          nums1Statistics.put(num, count);
        }
      }
    }

    int[] result = new int[intersection.size()];
    int idx = 0;
    for(Integer num : intersection) {
      result[idx++] = num;
    }
    return result;
  }
}