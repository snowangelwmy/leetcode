/**
 * Test cases:
 * 1: Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 2: Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * 3: Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 4: Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 */

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;

class Q1249 {

    private static final char LEFT = '(';

    private static final char RIGHT = ')';

    public String minRemoveToMakeValid(String s) {
        if(s==null||s.length()==0) {
            return s;
        }

        Stack<Integer> lefts = new Stack<>();
        List<Integer> rights = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c==LEFT) {
                lefts.push(new Integer(i));
            } else if(c==RIGHT) {
                if(lefts.isEmpty()) {
                    rights.add(new Integer(i));
                } else {
                    lefts.pop();
                }
            }
        }

        while(!lefts.isEmpty()) {
            int index = lefts.pop();
            rights.add(new Integer(index));
        }
        Collections.sort(rights);

        StringBuilder builder = new StringBuilder(s);
        for(int i=rights.size()-1; i>=0; i--) {
            int index = rights.get(i);
            builder.deleteCharAt(index);
        }

        return builder.toString();
    }
}