/**
 * Test cases:
 * 1: Input: [3,4,5,1,2]
 * Output: 1
 * 2: Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

class Q153 {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) {
            return Integer.MIN_VALUE;
        }
        return findMinHelper(nums, 0, nums.length-1);
    }

    private int findMinHelper(int[] nums, int start, int end) {
        if(start==end) {
            return nums[start];
        }

        while(start<end) {
            int mid = (start+end)/2;
            if(nums[mid]>nums[start]) {
                if(nums[start]>nums[end]) {
                    start = mid + 1;
                } else {//nums[start]<nums[end]
                    end = mid - 1;
                }
            } else if(nums[mid]<nums[start]) {
                end = mid;
            } else {//nums[mid]==nums[start]
                if(nums[start]<nums[end]) {
                    end = end-1;
                } else {//nums[start]>nums[end]
                    start = start+1;
                }
            }
        }

        return nums[start];
    }
}