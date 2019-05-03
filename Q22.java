/**
 * Test cases:
 * 1: Input: 3
 * Output:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String prefix, int left, int right, int max) {
        if(prefix.length()==max*2) {
            result.add(prefix);
            return;
        }

        if(left<max) {
            backtrack(result, prefix+"(", left+1, right, max);
        }
        if(right<left) {
            backtrack(result, prefix+")", left, right+1, max);
        }
    }
}