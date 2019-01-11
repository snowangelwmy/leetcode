/**
 * Test cases:
 * 1: Input: [1,2,3]
 * Output: 3
 * Explanation: Only three moves are needed (remember each move increments two elements):
 *  [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

class Q453 {
    public int minMoves(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int minimum = Integer.MAX_VALUE;
        int sum  = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(nums[i]<minimum) {
                minimum = nums[i];
            }
        }
        return sum - minimum*nums.length;
    }
}