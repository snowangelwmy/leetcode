/**
 * Test cases:
 * 1: Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 2: Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * 3: Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 4: Input: num = "112", k = 1
 * Output: "11"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Q402 {
    //https://leetcode.com/problems/remove-k-digits/discuss/462698/Java-Solution-Clean-and-Easy-to-Understand-with-Stack
    public String removeKdigits(String num, int k) {
        if(num==null||num.length()<=k) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            int cur = num.charAt(i) - '0';
            if(stack.isEmpty()||stack.peek()<cur) {
                stack.push(cur);
            } else {//!stack.isEmpty()&&stack.peek()>=cur
                while(!stack.isEmpty()&&stack.peek()>cur&&k>0) {
                    stack.pop();
                    k--;
                }
                stack.push(cur);
            }
        }
        while(k>0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.reverse();

        int index = 0;
        for(int i=0; i<builder.length(); i++) {
            if(builder.charAt(i)=='0') {
                index++;
            } else {
                break;
            }
        }

        return index == builder.length() ? "0" : builder.substring(index);
    }
}