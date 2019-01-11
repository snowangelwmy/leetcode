/**
 * Test cases:
 * 1: Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * 2: Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * 3: Input: [2,1,1,2]
 * Output: 4
 * Explanation: Rob house 1 (money = 2), and rob house 4 (money = 2).
 *              Total amount you can rob = 2 + 2 = 4.
 */

import java.lang.Math;

class Q198 {
  public int rob(int[] nums) {
    if(nums==null||nums.length==0){
      return 0;
    }
    int[] max = new int[nums.length];
    for(int i=0; i<nums.length; i++){
      if(i==0){
        max[i] = nums[i];
      } else if(i==1){
        max[i] = Math.max(nums[i-1],nums[i]);
      } else { //1<i<nums.length
        max[i] = Math.max(max[i-1], max[i-2]+nums[i]);
      }
    }
    return max[nums.length-1];
  }
}