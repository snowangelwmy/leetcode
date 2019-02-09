/**
 * Test cases:
 * 1: Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 2: Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

import java.util.Map;
import java.util.HashMap;

class Q279 {
    private static Map<Integer, Integer> lookup = new HashMap<>();

    public int numSquares(int n) {
        if(n<=0) {
            return 0;
        }
        if(lookup.size()>n) {
            return lookup.get(n);
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++) {
            min = Math.min(min, numSquares(n-i*i)+1);
        }
        lookup.put(n, min);
        return min;
    }
}