/**
 * Test cases:
 * 1: Input: 3
 * Output: "III"
 * 2: Input: 4
 * Output: "IV"
 * 3: Input: 9
 * Output: "IX"
 * 4: Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 5: Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 6: Input: 2
 * Output: "II"
 * 7: Input: 12
 * Output: "XII"
 * 8: Input: 27
 * Output: "XXVII"
 */


import java.lang.StringBuilder;

class Q12 {
    public String intToRoman(int num) {
        //char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'}; // cannot use char[], since charA + charB will be an integer instead of char concatenation
        String[] symbols = {"I", "V", "X", "L", "C", "D", "M"};

        StringBuilder res = new StringBuilder();
        int pos = 0;
        while(num > 0) {
            int tail = num%10;
            if(tail<4) {
                for(int i=0; i<tail; i++) {
                    res.insert(0, symbols[2*pos]);
                }
            } else if(tail==4) {
                res.insert(0, symbols[2*pos]+symbols[2*pos+1]);
            } else if(tail>4 && tail<9) {
                for(int i=0; i<tail-5; i++) {
                    res.insert(0, symbols[2*pos]);
                }
                res.insert(0, symbols[2*pos+1]);
            } else if(tail==9) {
                res.insert(0, symbols[2*pos]+symbols[2*pos+2]);
            }

            pos++;
            num /= 10;
        }

        return res.toString();
    }
}