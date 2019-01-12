/**
 * Test cases:
 * 1: Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 */

public class Q485 {

  public int findMaxConsecutiveOnes(int[] nums) {
    int maxOnes = 0;
    if(nums==null || nums.length==0) {
      return maxOnes;
    }

    int ones = 0;
    for(int i=0; i<nums.length; i++) {
      if(nums[i]==1) {
        ones++;
        if(ones>maxOnes) {
          maxOnes = ones;
        }
      } else {
        ones = 0;
      }
    }

    return maxOnes;
  }

}
