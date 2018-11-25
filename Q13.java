/**
 * Test cases:
 * 1: Input: "III", Output: 3
 * 2: Input: "IV", Output: 4
 * 3: Input: "IX", Output: 9
 * 4: Input: "LVIII", Output: 58
 * 5: Input: "MCMXCIV", Output: 1994
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    private static final Map<Character, Integer> lookup;
    static {
        lookup = new HashMap();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;

        if (s==null||s.length()<=0){
            return result;
        }

        int length = s.length();
        for(int i=0; i<length; i++){
            int curValue = lookup.get(s.charAt(i));
            if (i+1<length && curValue < lookup.get(s.charAt(i+1))) {
                curValue *= -1;
            }

            result += curValue;
        }

        return result;

    }
}