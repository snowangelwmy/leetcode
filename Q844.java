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
 * 5: Input: S = "oi###mupo##rszty#s#xu###bxx##dqc#gdjz", T = "oi###mupo##rszty#s#xu####bxx##dqc#gdjz"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Q844 {

    //O(min(M,N)) time and O(1) space
    public boolean backspaceCompare2(String S, String T) {
        if(S==null&&T==null) {
            return true;
        } else if(S==null||T==null) {
            return false;
        }
        int i = S.length()-1, j = T.length()-1;
        int skipS = 0, skipT = 0;
        while(i>=0||j>=0){
            while(i>=0) {
                if(S.charAt(i)=='#') {
                    skipS++;
                    i--;
                } else if (skipS > 0){
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while(j>=0) {
                if(T.charAt(j)=='#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if(i>=0&&j>=0) {
                if(S.charAt(i)!=T.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else if(i>=0||j>=0) {
                return false;
            }
        }
        return true;
    }

    ////OM+N) time and O(M+N) space
    public boolean backspaceCompare1(String S, String T) {
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