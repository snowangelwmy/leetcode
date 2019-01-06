/**
 * Test cases:
 * 1: Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * 2: Input: "aba"
 * Output: False
 * 3: Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        String ss = s+s;
        return ss.substring(1, ss.length()-1).contains(s);
    }
}