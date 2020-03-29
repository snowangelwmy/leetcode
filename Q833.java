/**
 * Test cases:
 * 1: Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 * 2: Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 */

import java.util.PriorityQueue;

class Q833 {

    class Index {
        int index;
        int pos;

        public Index(int index, int pos) {
            this.index = index;
            this.pos = pos;
        }
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(S==null||S.length()==0) {
            return S;
        }

        PriorityQueue<Index> queue = new PriorityQueue<>((u, v) -> (v.pos - u.pos));
        for(int i=0; i<indexes.length; i++) {
            queue.offer(new Index(i, indexes[i]));
        }

        StringBuilder builder = new StringBuilder(S);
        while(!queue.isEmpty()) {
            Index curIndex = queue.poll();
            int index = curIndex.index;
            int pos = curIndex.pos;
            String curSource = sources[index];
            String curTarget = targets[index];
            if(S.substring(pos).startsWith(curSource)) {
                builder.replace(pos, pos+curSource.length(), curTarget);
            }
        }
        return builder.toString();
    }
}