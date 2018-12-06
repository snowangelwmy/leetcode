/**
 * Test cases:
 * 1: Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6, Explanation: [4,-1,2,1] has the largest sum = 6
 */

class Solution {
    //The Kadane’s Algorithm for this problem takes O(n) time.
    // Therefore the Kadane’s algorithm is better than the Divide and Conquer approach,
    // but this problem can be considered as a good example to show power of Divide and Conquer.
    public int maxSubArray1(int[] nums) {
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

    //Using Divide and Conquer approach, we can find the maximum subarray sum in O(nLogn) time.
    public int maxSubArray2(int[] nums) {
        if(nums==null||nums.length==0){
            return Integer.MIN_VALUE;
        }

        return maxSubArraySum(nums,0,nums.length-1);
    }

    private static int maxSubArraySum(int[] nums, int low, int high) {
        // Base Case: Only one element
        if(low==high) {
            return nums[low];
        }

        // Find middle point
        int mid = (low+high)/2;

        /* Return maximum of following three possible cases:
        a) Maximum subarray sum in left half
        b) Maximum subarray sum in right half
        c) Maximum subarray sum such that the subarray crosses the midpoint */
        return Math.max(Math.max(maxSubArraySum(nums,low,mid),
                maxSubArraySum(nums,mid+1,high)),
                maxCrossingSubArraySum(nums,low,mid,high));
    }

    private static int maxCrossingSubArraySum(int[] nums, int low, int mid, int high) {
        // Include elements on left of mid.
        int tempSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i=mid; i>=low; i--){
            tempSum += nums[i];
            if(tempSum>leftMax){
                leftMax=tempSum;
            }
        }

        // Include elements on right of mid
        tempSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for(int i=mid+1;i<=high;i++){
            tempSum += nums[i];
            if(tempSum>rightMax){
                rightMax=tempSum;
            }
        }

        // Return sum of elements on left and right of mid
        return leftMax+rightMax;
    }
}