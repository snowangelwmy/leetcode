/**
 * Test cases:
 * 1: Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Q763 {

    class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> parts = new ArrayList<>();

        if(S==null||S.length()==0) {
            return null;
        }

        if(S.length()==1) {
            parts.add(0);
            return parts;
        }

        Map<Character, Range> lookup = new HashMap<>();
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(!lookup.containsKey(c)) {
                lookup.put(c, new Range(i, i));
            }
            lookup.get(c).end = i;
        }

        int start = 0;
        while(start<S.length()) {
            char initC = S.charAt(start);
            Range initRange = lookup.get(initC);
            int end = initRange.end;
            for(int i=start; i<=end; i++) {
                char curC = S.charAt(i);
                Range curRange = lookup.get(curC);
                if(curRange.end>end) {
                    end = curRange.end;
                }
            }
            parts.add(end-start+1);
            start = end + 1;
        }

        return parts;
    }
}