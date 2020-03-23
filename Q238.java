/**
 * Test cases:
 * 1: Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */

class Q238 {

    //with constant space complexity
    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length<2) {
            return null;
        }

        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i<nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int right = 1;
        for(int i=nums.length-2; i>=0; i--) {
            right *= nums[i+1];
            result[i] *= right;
        }

        return result;
    }

    //with extra space complexity
    public int[] productExceptSelf0(int[] nums) {
        if(nums==null||nums.length<2) {
            return null;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;

        for(int i=1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i=nums.length-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}