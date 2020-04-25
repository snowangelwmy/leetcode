/**
 * Test cases:
 * 1: Input: 3
 * Output: 5
 * Explanation:
 * The five different ways are listed below, different letters indicates different tiles:
 * XYZ XXZ XYY XXY XYY
 * XYZ YYZ XZZ XYY XXY
 * 2: Input: 5
 * Output: 24
 * 3: Input: 60
 * Output: 882347204
 */

import java.util.Map;
import java.util.HashMap;

class Q790 {
    //https://leetcode.com/problems/domino-and-tromino-tiling/discuss/288662/Java-O(N)-dp-solution-with-really-simple-math
    public int numTilings(int N) {
        if(N<0) {
            return 0;
        }
        Map<Integer, Integer> lookup = new HashMap<>();
        lookup.put(1, 1);
        lookup.put(2, 2);
        lookup.put(3, 5);
        if(N<=3) {
            return lookup.get(N);
        }
        int mod = 1000000007;
        for(int i=4; i<=N; i++) {
            //https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-addition-and-subtraction
            //(A + B) mod C = (A mod C + B mod C) mod C
            int cur = 2*lookup.get(i-1)%mod + lookup.get(i-3)%mod;
            lookup.put(i, cur%mod);
        }

        return lookup.get(N);
    }

    //Wrong Answer when N=60
    public int numTilings1(int N) {
        if(N<0) {
            return 0;
        }
        Map<Integer, Long> lookup = new HashMap<>();
        lookup.put(1, 1L);
        lookup.put(2, 2L);
        lookup.put(3, 5L);
        if(N<=3) {
            return (int)((long)lookup.get(N));
        }
        int mod = 1000000007;
        for(int i=4; i<=N; i++) {
            lookup.put(i, 2*lookup.get(i-1)+lookup.get(i-3)); //probably overflow
        }

        return (int)(lookup.get(N)%mod);
    }

    //Time Limit Exceeded
    public int numTilings0(int N) {
        if(N<0) {
            return 0;
        }
        Map<Integer, Long> lookup = new HashMap<>();
        int mod = 1000000007;
        return (int)(numTilingsHelper(N, lookup)%mod);
    }

    private Long numTilingsHelper(int N, Map<Integer, Long> lookup) {
        if(lookup.containsKey(N)) {
            return lookup.get(N);
        }
        if(N==1) {
            lookup.put(1, 1L);
            return lookup.get(N);
        }
        if(N==2) {
            lookup.put(2, 2L);
            return lookup.get(N);
        }
        if(N==3) {
            lookup.put(3, 5L);
            return lookup.get(N);
        }
        long minusOne = numTilingsHelper(N-1, lookup);
        long minusThree = numTilingsHelper(N-3, lookup);
        return 2*minusOne + minusThree;
    }
}