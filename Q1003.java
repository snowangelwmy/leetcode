/**
 * Test cases:
 * 1: Input: "aabcbc"
 * Output: true
 * Explanation:
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
 * 2: Input: "abcabcababcc"
 * Output: true
 * Explanation:
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
 * 3: Input: "abccba"
 * Output: false
 * 4: Input: "cababc"
 * Output: false
 */

import java.util.Stack;

class Q1003 {
    public boolean isValid(String S) {
        if(S==null||S.length()<3) {
            return false;
        }

        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            switch(c) {
                case 'a':
                    int[] newSeq = new int[3];
                    newSeq[0] = i;
                    newSeq[1] = 0;
                    newSeq[2] = 0;
                    stack.push(newSeq);
                    break;
                case 'b':
                    if(stack.isEmpty()) {
                        return false;
                    }
                    int[] curSeq1 = stack.peek();
                    if(curSeq1[1]!=0) {
                        return false;
                    } else {
                        curSeq1[1] = i;
                    }
                    break;
                case 'c':
                    if(stack.isEmpty()) {
                        return false;
                    }
                    int[] curSeq2 = stack.peek();
                    if(curSeq2[1]==0) {
                        return false;
                    } else {
                        curSeq2[2] = i;
                    }
                    stack.pop();
                    break;
                default:
                    System.out.println("Invalid character!");
                    break;
            }
        }

        return stack.isEmpty();
    }
}