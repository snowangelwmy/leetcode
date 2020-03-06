/**
 * Test cases:
 * 1: Input: nums = [1,2,5,9], threshold = 6
 * Output: 5
 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
 * If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
 * 2: Input: nums = [2,3,5,7,11], threshold = 11
 * Output: 3
 * 3: Input: nums = [19], threshold = 5
 * Output: 4
 */

class Q1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums==null||nums.length==0||nums.length>threshold) {
            return -1;
        }

        int high = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            high = Math.max(high, nums[i]);
        }

        //sum>threshold
        if(nums.length==threshold) {
            return high;
        }

        //nums.length<threshold && sum>threshold    
        int result = Integer.MAX_VALUE;
        int low = 1;
        while(low<=high) {
            int mid = (low+high)/2;
            long curSum = getSum(nums, mid);
            if(curSum<=threshold) {
                result = Math.min(result, mid);
                high = mid -1;
            } else {//curSum>threshold
                low = mid + 1;
            }
        }

        return result;
    }

    private long getSum(int[] nums, int divisor) {
        long sum = 0; //avoid overflow
        for(int num : nums) {
            sum += num/divisor;
            sum += num%divisor==0 ? 0 : 1;
        }
        return sum;
    }
}