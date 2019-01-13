/**
 * Test cases:
 * 1: Input: 100
 * Output: "202"
 * 2: Input: -7
 * Output: "-10"
 * 3: Input: 0
 * Output: "0"
 * 4: Input: -8
 * Output: "-11"
 */

import java.lang.Math;

class Q504 {
    public String convertToBase7(int num) {
        if(num==0) {
            return "0";
        }
        int absNum = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while(absNum!=0){
            builder.insert(0, absNum%7);
            absNum /= 7;
        }
        if(num<0) {
            builder.insert(0, '-');
        }
        return builder.toString();
    }
}