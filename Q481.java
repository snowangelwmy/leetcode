/**
 * Test cases:
 * 1: Input: 6
 * Output: 3
 * Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 */

import java.util.Queue;
import java.util.LinkedList;

class Q481 {
    //https://leetcode.com/problems/magical-string/discuss/96416/Short-Java-with-Queue-and-one-loop-O(N)-in-time-and-O(1)-in-space
    public int magicalString(int n) {
        if(n<=0) {
            return 0;
        }

        if(n<=3) {
            return 1;
        }

        int next = 4;
        int numOfOnes = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        boolean isOne = true;
        while(next<=n) {
            int count = queue.poll();
            while(count>0 && next<=n) {
                if(isOne) {
                    queue.offer(1);
                    numOfOnes++;
                } else {
                    queue.offer(2);
                }
                count--;
                next++;
            }
            isOne = !isOne;
        }

        return numOfOnes;
    }
}