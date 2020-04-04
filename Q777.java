/**
 * Test cases:
 * 1: Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * 2: Input: start = "XXXXXLXXXX", end = "LXXXXXXXXX"
 * Output: True
 */

import java.util.Queue;
import java.util.LinkedList;

class Q777 {
    public boolean canTransform(String start, String end) {
        if(start.length()!=end.length()) { return false; }
        Queue<CharInfo> sq = new LinkedList<>();
        Queue<CharInfo> eq = new LinkedList<>();
        for(int i=0; i<start.length(); i++) {
            if(start.charAt(i)!='X') { sq.offer(new CharInfo(start.charAt(i), i)); }
            if(end.charAt(i)!='X') { eq.offer(new CharInfo(end.charAt(i), i)); }
        }
        if(sq.size()!=eq.size()) { return false; }
        while(!sq.isEmpty()) {
            CharInfo sc = sq.poll();
            CharInfo ec = eq.poll();
            if(sc.c!=ec.c) { return false; }
            if(sc.c=='L' && sc.index < ec.index) { return false; }
            if(sc.c=='R' && sc.index > ec.index) { return false; }
        }
        return true;
    }

    private class CharInfo {
        private char c;
        private int index;

        public CharInfo(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }
}