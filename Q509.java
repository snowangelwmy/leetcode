/**
 * Test cases:
 * 1: Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 2: Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 3: Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */

import java.util.Map;
import java.util.HashMap;

class Solution {

    private Map<Integer, Integer> lookup = new HashMap<>();

    public int fib(int N) {
        if(N<0) {
            return -1;
        }

        if(lookup.containsKey(N)) {
            return lookup.get(N);
        }

        int fibNum;
        if(N==0) {
            fibNum = 0;
        } else if(N==1) {
            fibNum = 1;
        } else { //N>1
            fibNum = fib(N-1) + fib(N-2);
        }
        lookup.put(N, fibNum);
        return fibNum;
    }
}