/**
 * Test cases:
 * 1: Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 2: Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 3: Input: nums = [1,3,1,1,1], target = 3
 * Output: true
 */


class Q81 {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0) {
            return false;
        }
        int low = 0; int high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                return true;
            } //if mid is in the left side
            else if(nums[mid]>nums[low]||nums[mid]>nums[high]) {
                if(target>=nums[low]&&target<nums[mid]) {
                    high = mid-1;
                } else {//target<nums[low]||target>nums[mid]
                    low = mid+1;
                }
            } //if mid in the right side
            else if(nums[mid]<nums[low]||nums[mid]<nums[high]) {
                if(target>nums[mid]&&target<=nums[high]) {
                    low = mid+1;
                } else {//target<nums[mid]||target>nums[high]
                    high = mid-1;
                }
            } else {//nums[mid]==nums[low]==nums[high]
                high--;
            }
        }
        return false;
    }
}