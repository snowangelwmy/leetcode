/**
 * Test cases:
 * 1: Input: [3,0,1]
 * Output: 2
 * 2: Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */

class Q268 {
  public int missingNumber(int[] nums) {
    if(nums==null||nums.length==0){
      return Integer.MIN_VALUE;
    }
    int n = nums.length;
    int missing = n;
    for(int i=0; i<n; i++){
      missing ^= i;
      missing ^= nums[i];
    }
    return missing;
  }
}