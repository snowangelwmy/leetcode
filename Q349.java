/**
 * Test cases:
 * 1: Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 */

import java.util.Set;
import java.util.HashSet;

class Q349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    if(nums1==null||nums2==null){
      return null;
    }

    Set<Integer> nums1Set = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();
    for(int i=0; i<nums1.length; i++){
      nums1Set.add(nums1[i]);
    }
    for(int i=0; i<nums2.length; i++){
      if(nums1Set.contains(nums2[i])) {
        intersection.add(nums2[i]);
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