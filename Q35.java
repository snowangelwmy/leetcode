/**
 * Test cases:
 * 1: Input: [1,3,5,6], 5, Output: 2
 * 2: Input: [1,3,5,6], 2, Output: 1
 * 3: Input: [1,3,5,6], 7, Output: 4
 * 4: Input: [1,3,5,6], 0, Output: 0
 */

class Q35 {

    //Binary search approach: https://leetcode.com/problems/search-insert-position/discuss/515414/Java-using-binary-search-O(nlogn)-100-100
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int middle = (start + end) / 2;
            int num = nums[middle];
            if (num == target) {
                return middle;
            } else if (target > num) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    public int searchInsert0(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return 0;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]>=target){
                return i;
            }
        }

        return nums.length;
    }
}