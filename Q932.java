/**
 * Test cases:
 * 1: Input: 4
 * Output: [2,1,4,3]
 * 2: Input: 5
 * Output: [3,1,2,5,4]
 */

import java.util.Map;
import java.util.HashMap;

class Q932 {

    //https://leetcode.com/problems/beautiful-array/solution/
    public int[] beautifulArray(int N) {
        Map<Integer, int[]> memo = new HashMap<>();
        return beautifulArrayHelper(N, memo);
    }

    private int[] beautifulArrayHelper(int N, Map<Integer, int[]> memo) {
        if(memo.containsKey(N)) {
            return memo.get(N);
        }

        if(N==1) {
            int[] nums = {1};
            memo.put(1, nums);
            return nums;
        }

        int[] nums = new int[N];
        int t = 0;
        int[] oddNums = beautifulArrayHelper((N+1)/2, memo);
        for(int i=0; i<oddNums.length; i++) {
            nums[t++] = 2 * oddNums[i] - 1;
        }
        int[] evenNums = beautifulArrayHelper(N/2, memo);
        for(int i=0; i<evenNums.length; i++) {
            nums[t++] = 2 * evenNums[i];
        }
        memo.put(N, nums);
        return nums;
    }
}