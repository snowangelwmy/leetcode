/**
 * Test cases:
 * 1: Input: "cdadabcc"
 * Output: "adbc"
 * 2: Input: "abcd"
 * Output: "abcd"
 * 3: Input: "ecbacba"
 * Output: "eacb"
 * 4: Input: "leetcode"
 * Output: "letcod"
 * 5: Input: "ddeeeccdce"
 * Output: "cde"
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Q1081 {

    //https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/discuss/393109/Java-or-Stack-or-Greedy-or-O(n)-Time-and-Memory
    private static final int NUM = 26;

    public String smallestSubsequence(String text) {
        if(text==null||text.length()<2) {
            return text;
        }

        int[] counts = new int[NUM];
        for(int i=0; i<text.length(); i++) {
            int index = text.charAt(i)-'a';
            counts[index]++;
        }

        boolean[] visited = new boolean[NUM];
        Stack<Integer> chars = new Stack<>();
        for(int i=0; i<text.length(); i++) {
            int index = text.charAt(i)-'a';
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