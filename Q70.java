/**
 * Test cases:
 * 1: Input: 2, Output: 2
 * 2: Input: 3, Output: 3
 * 3: Input: 38, Output: 63245986
 */

import java.util.Map;
import java.util.HashMap;

class Q70 {
    private static Map<Integer, Integer> lookup = new HashMap<>();

    public int climbStairs(int n) {
        if(n<=0){
            return -1;
        }

        if(lookup.containsKey(n)){
            return lookup.get(n);
        } else if(n==1){
            lookup.put(1, 1);
        } else if(n==2){
            lookup.put(2, 2);
        } else {//n>2
            lookup.put(n, climbStairs(n-1)+climbStairs(n-2));
        }
        return lookup.get(n);
    }
}