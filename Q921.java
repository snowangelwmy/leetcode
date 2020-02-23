/**
 * Test cases:
 * 1: Input: "())"
 * Output: 1
 * 2: Input: "((("
 * Output: 3
 * 3: Input: "()"
 * Output: 0
 * 4: Input: "()))(("
 * Output: 4
 */

import java.util.Stack;

class Q921 {

    private static final char LEFT = '(';

    private static final char RIGHT = ')';

    public int minAddToMakeValid(String S) {
        if(S==null||S.length()==0) {
            return 0;
        }

        Stack<Character> lefts = new Stack<>();
        int rights = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c==LEFT) {
                lefts.push(c);
            } else if(c==RIGHT) {
                if(lefts.isEmpty()) {
                    rights++;
                } else {
                    lefts.pop();
                }
            }
        }

        return lefts.size() + rights;
    }
}