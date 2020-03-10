/**
 * Test cases:
 * 1: Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * 2: Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * 3: Input: s = "abc"
 * Output: 1
 */

import java.util.Map;
import java.util.HashMap;

class Q1358 {

    private static final int COUNT = 3;

    public int numberOfSubstrings(String s) {
        if(s==null||s.length()<3) {
            return 0;
        }

        Map<Character, Integer> lookup = new HashMap<>();
        int totalCount = 0;
        int count = 0;
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            if(!lookup.containsKey(c)) {
                lookup.put(c, 0);
            }
            lookup.put(c, lookup.get(c)+1);

            while(lookup.size()==COUNT) {
                count++;
                char firstC = s.charAt(left);
                if(lookup.get(firstC)>1) {
                    lookup.put(firstC, lookup.get(firstC)-1);
                } else {
                    lookup.remove(firstC);
                }
                left++;
            }

            totalCount += count;
        }

        return totalCount;
    }
}