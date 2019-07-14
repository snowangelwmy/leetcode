/**
 * Test cases:
 * 1: Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 2: Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */

class Q55 {

    //Dynamic Programming Bottom-up
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) {
            return false;
        }

        int[] memo = new int[nums.length];
        memo[nums.length-1] = 1;

        for(int i=nums.length-2; i>=0; i--) {
            int maxJump = Math.min(i+nums[i], nums.length-1);
            for(int j=maxJump; j>i; j--) {
                if(memo[j]==1) {
                    memo[i] = 1;
                    break;
                }
            }
            if(memo[i]==0) {
                memo[i] = -1;
            }
        }
        return memo[0]==1 ? true : false;
    }

    //Dynamic Programming Top-down (optimized backtracking)
    public boolean canJump0(int[] nums) {
        if(nums==null||nums.length==0) {
            return false;
        }
        int[] memo = new int[nums.length];
        return canJumpHelper(0, nums, memo);
    }

    private boolean canJumpHelper(int index, int[] nums, int[] memo) {
        if(memo[index]!=0) {
            return memo[index]==1? true : false;
        }

        if(index==nums.length-1) {
            memo[index] = 1;
            return true;
        }

        int maxIndex = Math.min(index+nums[index], nums.length-1);
        for(int i=maxIndex; i>index; i--) {
            if(canJumpHelper(i, nums, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[index] = -1;
        return false;
    }
}
