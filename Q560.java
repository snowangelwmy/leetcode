/**
 * Test cases:
 * 1: Input:nums = [1,1,1], k = 2
 * Output: 2
 */

class Q560 {
    public int subarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }

        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j>=0; j--) {
                int sum = prefixSums[i] - prefixSums[j] + nums[j];
                if(sum==k) {
                    count++;
                }
            }
        }

        return count;
    }
}