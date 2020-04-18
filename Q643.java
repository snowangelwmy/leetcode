/**
 * Test cases:
 * 1: Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 */

class Q643 {
    public double findMaxAverage(int[] nums, int k) {
        if(nums==null||nums.length<k) {
            return 0.0;
        }

        int left = 0;
        int right = k-1;
        int sum = 0;
        for(int i=left; i<=right; i++) {
            sum += nums[i];
        }
        double maxAve = sum/(double)k;
        while(++right<nums.length) {
            sum -= nums[left++];
            sum += nums[right];
            maxAve = Math.max(maxAve, sum/(double)k);
        }
        return maxAve;
    }
}