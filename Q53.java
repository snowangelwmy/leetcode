/**
 * Test cases:
 * 1: Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6, Explanation: [4,-1,2,1] has the largest sum = 6
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        if(nums==null||nums.length==0){
            return maxSum;
        }

        int tempSum = 0;
        for(int i=0; i<nums.length; i++){
            tempSum += nums[i];
            if(tempSum>maxSum){
                maxSum = tempSum;
            }
            if(tempSum<0){
                tempSum=0;
            }
        }
        return maxSum;
    }
}