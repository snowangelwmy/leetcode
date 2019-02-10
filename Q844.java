/**
 * Test cases:
 * 1: Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 2: Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 3: Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 4: Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Q844 {
    public boolean backspaceCompare(String S, String T) {
        if(S==null&&T==null) {
            return true;
        } else if(S==null||T==null) {
            return false;
        }
        return removeBackspace(S).equals(removeBackspace(T));
    }

    private String removeBackspace(String s) {
        Stack<Character> lookup = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c!='#') {
                lookup.push(Character.valueOf(c));
            } else {
                if(!lookup.empty()) {
                    lookup.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!lookup.empty()) {
            builder.insert(0, lookup.pop());
        }
        return builder.toString();
    }
}