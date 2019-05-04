/**
 * Test cases:
 * 1: Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 2: Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 3: Input: nums = [-1,0,3,5,9,12], target = 13
 * Output: -1
 * Explanation: 13 does not exist in nums so return -1
 */

class Q704 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]<target) {
                low++;
            } else {//nums[mid]>target
                high--;
            }
        }
        return -1;
    }
}