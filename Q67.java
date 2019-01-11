/**
 * Test cases:
 * 1: Input: a = "11", b = "1", Output: "100"
 * 2: Input: a = "1010", b = "1011", Output: "10101"
 */

import java.lang.StringBuilder;

class Q67 {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0){
            return b;
        }

        if(b==null||b.length()==0){
            return a;
        }

        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(aIdx>=0||bIdx>=0){
            int sum = carry;
            if(aIdx>=0){
                sum += Character.getNumericValue(a.charAt(aIdx));
                aIdx--;
            }
            if(bIdx>=0){
                sum += Character.getNumericValue(b.charAt(bIdx));
                bIdx--;
            }
            if(sum>=2){
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            result.insert(0, sum);
        }
        if(carry==1){
            result.insert(0, carry);
        }
        return result.toString();
    }
}