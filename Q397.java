/**
 * Test cases:
 * 1: Input: 8
 * Output: 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 2: Input: 7
 * Output: 4
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * 3: Input: 100000000
 * Output: 31
 * 4: Input: 2147483647
 * Output: 32
 */

import java.util.Map;
import java.util.HashMap;

class Q397 {

    public int integerReplacement(int n) {
        if(n<=0) {
            return -1;
        }

        //Use Long here, otherwise, you will get StackOverflowError.
        Map<Long, Integer> lookup = new HashMap<>();
        return integerReplacementHelper(n, lookup);
    }

    private int integerReplacementHelper(long n, Map<Long, Integer> lookup) {
        if(lookup.containsKey(n)) {
            return lookup.get(n);
        }

        if(n==1) {
            lookup.put(1L, 0);
            return lookup.get(n);
        }

        if(n%2==0) {
            int half = integerReplacementHelper(n/2,lookup);
            lookup.put((long)n, 1+half);
        } else {
            int plus = integerReplacementHelper(n+1,lookup);
            int minus = integerReplacementHelper(n-1,lookup);
            lookup.put((long)n, 1+Math.min(plus, minus));
        }
        return lookup.get(n);
    }

    //Memory Limit Exceeded
    public int integerReplacement0(int n) {
        if(n<=0) {
            return -1;
        }

        int[] lookup = new int[n+2];
        return integerReplacementHelper(n, lookup);
    }

    private int integerReplacementHelper(int n, int[] lookup) {
        if(lookup[n]!=0) {
            return lookup[n];
        }

        if(n==1) {
            return 0;
        }

        if(n%2==0) {
            lookup[n] = 1+integerReplacementHelper(n/2,lookup);
        } else {
            lookup[n] = 1+Math.min(integerReplacementHelper(n+1,lookup), integerReplacementHelper(n-1,lookup));
        }
        return lookup[n];
    }
}