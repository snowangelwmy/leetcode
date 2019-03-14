/**
 * Test cases:
 * 1: Input: target = 3
 * Output: 2
 * Explanation:
 *  The shortest instruction sequence is "AA".
 *  Your position goes from 0->1->3.
 * 2: Input: target = 6
 * Output: 5
 * Explanation:
 *  The shortest instruction sequence is "AAARA".
 *  Your position goes from 0->1->3->7->7->6.
 * 3: Input: target = 1
 * Output: 1
 * Explanation:
 *  The shortest instruction sequence is "A".
 *  Your position goes from 0->1.
 */

import java.util.Arrays;

class Q818 {
    public int racecar(int target) {
        int[] lookup = new int[target+3];
        Arrays.fill(lookup, Integer.MAX_VALUE);
        lookup[0] = 0;
        lookup[1] = 1;
        lookup[2] = 4;
        for(int i=3; i<=target; i++) {
            int k = 32 - Integer.numberOfLeadingZeros(i);
            if(i == ((1<<k)-1)) {
                lookup[i] = k;
                continue;
            }
            for(int j=0; j<k-1; j++) {
                lookup[i] = Math.min(lookup[i], lookup[i-((1<<(k-1))-(1<<j))]+k-1+j+2);
            }
            if((1<<k)-1-i<i) {
                lookup[i] = Math.min(lookup[i], lookup[(1<<k)-1-i]+k+1);
            }
        }
        return lookup[target];
    }
}