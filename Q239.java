/**
 * Test cases:
 * 1: Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  2: Input: nums = [1,3,1,2,0,5], and k = 3
 * Output: [3,3,2,5]
 * Explanation:
 * Window position        Max
 * ---------------       -----
 * [1  3  1] 2  0  5       3
 *  1 [3  1  2] 0  5       3
 *  1  3 [1  2  0] 5       2
 *  1  3  1 [2  0  5]      5
 */

import java.util.Deque;
import java.util.LinkedList;

class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return new int[0];
        }

        int n = nums.length;
        int[] maxNums = new int[n-k+1];
        int next = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++) {
            while(!deque.isEmpty() && deque.peekFirst()<=i-k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if(i>=k-1) {
                maxNums[next++] = nums[deque.peekFirst()];
            }
        }
        return maxNums;
    }
}