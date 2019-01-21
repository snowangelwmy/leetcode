/**
 * Test cases:
 * 1: Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 2: Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 3: Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 4: Input: s= "100[leetcode]"
 * Output: "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
 */

import java.util.Stack;

class Q394 {
    public String decodeString(String s) {
        if(s==null||s.length()==0) {
            return s;
        }
        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();
        StringBuilder tempBuilder = new StringBuilder();
        int idx = 0;
        while(idx<s.length()) {
            char c = s.charAt(idx);
            if(Character.isDigit(c)) {
                int count = 0;
                while(Character.isDigit(c)) {
                    count = count * 10 + Character.getNumericValue(c);
                    idx++;
                    c = s.charAt(idx);
                }
                nums.push(count);
            }
            else if(c=='[') {
                strings.push(tempBuilder.toString());
                tempBuilder = new StringBuilder();
                idx++;
            } else if(c==']') {
                int count = nums.pop();
                String chars = tempBuilder.toString();
                tempBuilder = new StringBuilder(strings.pop());
                for(int j=0; j<count; j++) {
                    tempBuilder.append(chars);
                }
                idx++;
            } else {
                tempBuilder.append(c);
                idx++;
            }
        }

        return tempBuilder.toString();
    }
}