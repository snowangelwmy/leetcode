/**
 * Test cases:
 * 1: Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 */

import java.util.Map;
import java.util.HashMap;

class Q788 {

    Map<Integer, Integer> lookup = new HashMap<Integer, Integer>(){{
        put(0, 0);
        put(1, 1);
        put(2, 5);
        put(5, 2);
        put(6, 9);
        put(8, 8);
        put(9, 6);
    }};

    public int rotatedDigits(int N) {
        int count = 0;
        for(int i=1; i<=N; i++) {
            if(isGood(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(int n) {
        Integer newN = rotate(n);
        if(newN==null||(int)newN==n) {
            return false;
        }

        return true;
    }

    private Integer rotate(int n) {
        int newN = 0;
        int power = 1;
        while(n!=0) {
            int remainder = n%10;
            if(!lookup.containsKey(remainder)) {
                return null;
            }
            int curNum = lookup.get(remainder);
            newN += power * curNum;
            power *= 10;
            n /= 10;
        }
        return new Integer(newN);
    }
}