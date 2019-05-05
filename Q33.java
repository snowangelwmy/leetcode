/**
 * Test cases:
 * 1: Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 2: Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

class Q33 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(target==nums[mid]) {
                return mid;
            }
            else if(nums[low]<=nums[mid]) { //mid is in the first part of the array
                if(nums[low]<=target && target<nums[mid]) {
                    high = mid - 1;
                } else {//nums[low]>target || target>nums[mid]
                    low = mid + 1;
                }
            } else {//nums[low]>nums[mid]) //mid is in the second part of the array
                if(nums[mid]<target && target<=nums[high]) {
                    low = mid + 1;
                } else {//nums[mid]>target || target>nums[high]
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}