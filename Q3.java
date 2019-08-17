/**
 * Test cases:
 * 1: Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 2: Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 3: Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.Set;
import java.util.HashSet;

class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }
        int result = 0;
        int i = 0, j = 0, n = s.length();
        Set<Character> chars = new HashSet<>();
        while(i<n && j<n) {
            Character c = s.charAt(j);
            if(!chars.contains(c)) {
                chars.add(c);
                result = Math.max(result, j-i+1);
                j++;
            } else {
                chars.remove(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}