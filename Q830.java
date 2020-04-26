/**
 * Test cases:
 * 1: Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting 3 and ending positions 6.
 * 2: Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * 3: Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 */

import java.util.List;
import java.util.ArrayList;

class Q830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> results = new ArrayList<>();
        if(S==null||S.length()<3) {
            return results;
        }

        //S.length()>=3
        int start = 0;
        char preC = S.charAt(start);
        int count = 1;
        int end = 0;
        for(int i=1; i<S.length(); i++) {
            char curC = S.charAt(i);
            if(curC==preC) {
                count++;
                end++;
            } else {//curC!=preC
                if(count>=3) {
                    List<Integer> result = new ArrayList<>();
                    result.add(start);
                    result.add(end);
                    results.add(result);
                }
                preC = curC;
                start = i;
                end = i;
                count = 1;
            }
        }

        if(count>=3) {
            List<Integer> result = new ArrayList<>();
            result.add(start);
            result.add(end);
            results.add(result);
        }
        return results;
    }
}