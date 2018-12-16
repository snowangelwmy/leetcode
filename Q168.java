/**
 * Test cases:
 * 1: Input: 1
 * Output: "A"
 * 2: Input: 28
 * Output: "AB"
 * 3: Input: 701
 * Output: "ZY"
 * 4: Input: 52
 * Output: "AZ"
 */

import java.lang.StringBuilder;

class Solution {
    public String convertToTitle(int n) {
        if(n<=0){
            return "";
        }

        StringBuilder builder = new StringBuilder();
        //n>0
        while(n!=0){
            int residue = n%26;//[0,25]->[1,26]
            builder.insert(0, convertToChar(residue));
            n /= 26;
            if(residue==0){
                n -= 1;
            }
        }

        return builder.toString();
    }

    private char convertToChar(int residue){
        if(residue==0){
            return 'Z';
        }
        return (char)('A'+ residue-1);
    }
}