/**
 * Test cases:
 * 1: Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 2: Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 3: Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */

import java.lang.StringBuilder;

class Q1209 {
    public String removeDuplicates(String s, int k) {
        if(s==null||s.length()<k) {
            return s;
        }

        StringBuilder builder = new StringBuilder(s);
        while(s.length()>=k) {
            boolean hasDuplicate = false;
            char cur = '0';
            int count = 0;
            for(int i=s.length()-1; i>=0; i--) {
                if(s.charAt(i)==cur) {
                    count++;
                    if(count==k) {
                        hasDuplicate = true;
                        builder.delete(i, i+k);
                    }
                } else {
                    cur = s.charAt(i);
                    count = 1;
                }
            }
            if(!hasDuplicate) {
                break;
            }
            s = builder.toString();
        }

        return s;
    }
}