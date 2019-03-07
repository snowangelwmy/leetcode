/**
 * Test cases:
 * 1: Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 2: Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 */

class Q162 {
    // Approach 3: Iterative Binary Search
    // Time complexity : O(log_2(n)). We reduce the search space in half at every step.
    // Thus, the total search space will be consumed in log_2(n) steps.
    // Here, n refers to the size of nums array.
    // Space complexity : O(1). Constant extra space is used.
    public int findPeakElement3(int[] nums) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        int low = 0, high = nums.length-1;
        while(low<high) {
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid+1]) {
                high = mid;
            } else {//nums[mid]<=nums[mid+1]
                low = mid+1;
            }
        }
        return low;
    }


    // Approach 2: Recursive Binary Search
    // Time complexity : O(log_2(n)). We reduce the search space in half at every step.
    // Thus, the total search space will be consumed in log_2(n) steps.
    // Here, nn refers to the size of numsnums array.
    // Space complexity : O(log_2(n)). We reduce the search space in half at every step.
    // Thus, the total search space will be consumed in log_2(n) steps.
    // Thus, the depth of recursion tree will go upto log_2(n).
    public int findPeakElement2(int[] nums) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int low, int high) {
        if(low==high) {
            return low;
        }
        int mid = (low+high)/2;
        if(nums[mid]>nums[mid+1]) {
            return binarySearch(nums, low, mid);
        }
        //nums[mid]<=nums[mid+1]
        return binarySearch(nums, mid+1, high);
    }

    // Approach 1: Linear Scan
    // Time complexity : O(n). We traverse the nums array of size n once only.
    // Space complexity : O(1). Constant extra space is used.
    public int findPeakElement1(int[] nums) {
        if(nums==null||nums.length==0) {
            return -1;
        }
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }
}