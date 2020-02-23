/**
 * Test cases:
 * 1: Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * 2: Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * 3: Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 * 4: Input: S = "y959q969u3hb22odq595", K = 222280369
 * Output: "y"
 */

import java.lang.StringBuilder;
import java.lang.Character;

class Q880 {
    //https://leetcode.com/problems/decoded-string-at-index/solution/
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)) {
                size++;
            } else if(Character.isDigit(c)){
                int count = Character.getNumericValue(c);
                size *= count;
            }
        }

        if(size<K) {
            return null;
        }

        for(int i=S.length()-1; i>=0; i--) {
            K %= size;

            char c = S.charAt(i);
            if(K==0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }

            if(Character.isLetter(c)) {
                size--;
            } else if(Character.isDigit(c)){
                int count = Character.getNumericValue(c);
                size /= count;
            }
        }

        return null;
    }

    //Memory Limit Exceeded
    public String decodeAtIndex0(String S, int K) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)) {
                builder.append(c);
                index++;
            } else if(Character.isDigit(c)){
                int count = Character.getNumericValue(c);
                String cur = builder.toString();
                for(int j=1; j<count; j++) {
                    builder.append(cur);
                    index += cur.length();
                }
            }
            if(index>=K) {
                break;
            }
        }

        return String.valueOf(builder.toString().charAt(K-1));
    }
}