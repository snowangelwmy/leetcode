/**
 * Test cases:
 * 1: Input: "bcabc"
 * Output: "abc"
 * 2: Input: "cbacdcbc"
 * Output: "acdb"
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Q316 {

    private static final int NUM = 26;

    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()<2) {
            return s;
        }

        int[] counts = new int[NUM];
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i)-'a';
            counts[index]++;
        }

        boolean[] visited = new boolean[NUM];
        Stack<Integer> chars = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i)-'a';
            counts[index]--;
            if(visited[index]) {
                continue;
            }
            while(!chars.isEmpty() && chars.peek()>index && counts[chars.peek()]>0) {
                visited[chars.peek()] = false;
                chars.pop();
            }
            chars.push(index);
            visited[index] = true;
        }

        StringBuilder builder = new StringBuilder();
        while(!chars.isEmpty()) {
            builder.append((char)(chars.pop()+'a'));
        }
        return builder.reverse().toString();
    }
}