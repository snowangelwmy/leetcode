/**
 * Test cases:
 * 1: Input: "()", Output: true
 * 2: Input: "()[]{}", Output: true
 * 3: Input: "(]", Output: false
 * 4: Input: "([)]", Output: false
 * 5: Input: "{[]}", Output: true
 * 6: Input: "[", Output: false
 */

import java.util.Stack;
import java.util.List;
import java.util.Arrays;

class Q20 {
    private static final List<Character> leftBracketList = Arrays.asList('(', '{', '[');
    private static final List<Character> rightBracketList = Arrays.asList(')', '}', ']');

    public boolean isValid(String s) {
        if(s==null) {
            return false;
        } else if(s.length()==0){
            return true;
        }

        Stack<Character> openLeftBrackets = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(leftBracketList.contains(c)) {
                openLeftBrackets.push(c);
            } else if(rightBracketList.contains(c)) {
                if(openLeftBrackets.empty()) {
                    return false;
                }

                Character lastLeftBracket = openLeftBrackets.pop();
                if(!doesMatch(lastLeftBracket, c)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if(openLeftBrackets.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean doesMatch(Character leftBracket, Character rightBracket) {
        return rightBracketList.get(leftBracketList.indexOf(leftBracket))==rightBracket;
    }
}