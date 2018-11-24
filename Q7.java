/**
 * Test cases:
 * 1: Input: 123, Output: 321
 * 2: Input: -123, Output: -321
 * 3: Input: 120, Output: 21
 */

import java.lang.Math;

class Solution {
    public int reverse(int x) {
        long reversedX = 0L;

        int base = 10;
        while(x!=0){
            reversedX = reversedX*base + x%base;
            x = x/base;
        }

        if (reversedX > Math.pow(2, 31)-1 || reversedX < -1 * Math.pow(2, 31)) {
            return 0;
        }

        return (int) reversedX;
    }
}