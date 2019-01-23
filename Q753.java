/**
 * Test cases:
 * 1: Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * 2: Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 */

import java.util.Set;
import java.util.HashSet;

class Q753 {
    public String crackSafe(int n, int k) {
        if(n<1||k<1) {
            return "";
        }

        if(n==1&&k==1) {
            return "0";
        }

        Set<String> seen = new HashSet<>();
        StringBuilder input = new StringBuilder();

        StringBuilder start = new StringBuilder();
        for(int i=0; i<n-1; i++) {
            start.append('0');
        }
        dfs(start.toString(), k, seen, input);
        input.append(start.toString());

        return input.toString();
    }

    private void dfs(String node, int k, Set<String> seen, StringBuilder input) {
        for(int i=0; i<k; i++) {
            String next = node + i;
            if(!seen.contains(next)) {
                seen.add(next);
                dfs(next.substring(1), k, seen, input);
                input.append(i);
            }
        }
    }
}