/**
 * Test cases:
 * 1: Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 2: Input: numerator = 2, denominator = 1
 * Output: "2"
 * 3: Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * 4: Input: numerator = -1, denominator = -2147483648
 * Output: "0.0000000004656612873077392578125)"
 */

import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;

class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) {
            return "0";
        }
        if(denominator==0) {
            return "NAN";
        }

        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator); //avoid overflow
        long den = Math.abs((long)denominator);

        //integral part
        res.append(num/den);
        num %= den;
        if(num == 0) {
            return res.toString();
        }

        //fractional part
        res.append('.');
        Map<Long, Integer> lookup = new HashMap<>();
        while(num != 0) {
            lookup.put(num, res.length());
            num *= 10;
            res.append(num/den);
            num %= den;
            if(lookup.containsKey(num)) {
                res.insert(lookup.get(num), "(");
                res.append(")");
                break;
            }
        }
        return res.toString();
    }
}