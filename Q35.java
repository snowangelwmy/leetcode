/**
 * Test cases:
 * 1: Input: [1,3,5,6], 5, Output: 2
 * 2: Input: [1,3,5,6], 2, Output: 1
 * 3: Input: [1,3,5,6], 7, Output: 4
 * 4: Input: [1,3,5,6], 0, Output: 0
 */

class Q35 {
    public int searchInsert(int[] nums, int target) {
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