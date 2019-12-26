/**
 * Test cases:
 * 1: Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

class Q300 {
  // Time complexity : O(n^2).
  // Space complexity : O(n).
  public int lengthOfLIS(int[] nums) {
    if(nums==null||nums.length==0) { return 0; }

    int[] lengthCache = new int[nums.length];
    lengthCache[0] = 1;
    int result = 1;
    for(int i=1; i<nums.length; i++) {
      int maxLength = 1;
      for(int j=0; j<i; j++) {
        if(nums[j]<nums[i]) {
          maxLength = Math.max(maxLength, lengthCache[j] + 1);
        }
      }
      lengthCache[i] = maxLength;
      result = Math.max(result, lengthCache[i]);
    }
    return result;
  }
}