/**
 * Test cases:
 * 1: Input: [1,1,2], Output: 2
 * 2: Input: [0,0,1,1,1,2,2,3,3,4], Output: 5
 * 3: Input: [1,2,3,4], Output: 4
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }

        for(int i=0; i<nums.length-1; i++) {
            int lastNum = nums[i];
            int firstDuplicateIndex = -1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<=lastNum) {
                    firstDuplicateIndex = j;
                    break;
                }
            }
            if(firstDuplicateIndex!=-1){
                int nextNumIndex = -1;
                for(int j=firstDuplicateIndex+1; j<nums.length; j++){
                    if(nums[j]>lastNum){
                        nextNumIndex = j;
                        break;
                    }
                }

                if(nextNumIndex!=-1){
                    swap(nums, firstDuplicateIndex, nextNumIndex);
                } else {
                    return firstDuplicateIndex;
                }
            }
        }

        return nums.length;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}