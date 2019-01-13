/**
 * Test cases:
 * 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * 2: Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */

import java.util.Arrays;

public class Q496 {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if(nums1==null||nums1.length==0) {
      return new int[] {};
    }
    int[] nextGreaterElements = new int[nums1.length];
    Arrays.fill(nextGreaterElements, -1);
    if(nums2==null||nums2.length==0) {
      return nextGreaterElements;
    }
    for(int i=0; i<nums1.length; i++) {
      int index = -1;
      for(int j=0; j<nums2.length; j++) {
        if(nums2[j]==nums1[i]) {
          index = j;
        } else if(nums2[j]>nums1[i] && index != -1 && nextGreaterElements[i]==-1) {
          nextGreaterElements[i] = nums2[j];
        }
      }
    }

    return nextGreaterElements;
  }
}
