/**
 * Test cases:
 * 1: Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 2: Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

class Q34 {
  public int[] searchRange(int[] nums, int target) {
    if(nums==null||nums.length==0) {
      return new int[] {-1, -1};
    }

    int[] result = new int[] {-1, -1};
    int low = 0;
    int high = nums.length-1;
    while(low<=high) {
      int mid = low + (high-low)/2;
      if(nums[mid]==target) {
        int start = mid;
        while(start-1>=0 && nums[start-1]==nums[mid]) { start--; }
        int end = mid;
        while(end+1<nums.length && nums[end+1]==nums[mid]) { end++; }
        result[0] = start;
        result[1] = end;
        return result;
      } else if(nums[mid]<target) {
        low++;
      } else {//nums[mid]>target
        high--;
      }
    }
    return result;
  }
}