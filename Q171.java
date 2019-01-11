/**
 * Test cases:
 * 1: Input: "A"
 * Output: 1
 * 2: Input: "AB"
 * Output: 28
 * 3: Input: "ZY"
 * Output: 701
 */

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

class Q171 {
    private static final Map<Character, Integer> LOOK_UP = initializeLookup();

    static Map<Character, Integer> initializeLookup() {
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('A', 1);
        lookup.put('B', 2);
        lookup.put('C', 3);
        lookup.put('D', 4);
        lookup.put('E', 5);
        lookup.put('F', 6);
        lookup.put('G', 7);
        lookup.put('H', 8);
        lookup.put('I', 9);
        lookup.put('J', 10);
        lookup.put('K', 11);
        lookup.put('L', 12);
        lookup.put('M', 13);
        lookup.put('N', 14);
        lookup.put('O', 15);
        lookup.put('P', 16);
        lookup.put('Q', 17);
        lookup.put('R', 18);
        lookup.put('S', 19);
        lookup.put('T', 20);
        lookup.put('U', 21);
        lookup.put('V', 22);
        lookup.put('W', 23);
        lookup.put('X', 24);
        lookup.put('Y', 25);
        lookup.put('Z', 26);
        return lookup;
    }

    public int titleToNumber(String s) {
        int num = 0;
        if(s==null||s.length()==0){
            return num;
        }

        for(int i=s.length()-1; i>=0; i--){
            Character c = Character.valueOf(s.charAt(i));
            if(LOOK_UP.containsKey(c)){
                num += LOOK_UP.get(c) * Math.pow(26, s.length()-1-i);
            }
        }

        return num;
    }
}