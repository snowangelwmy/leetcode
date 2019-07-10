/**
 * Test cases:
 * 1: Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 *     A
 *    / \
 *   G   E
 *  / \ / \
 * B   C   D
 *
 * We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.
 * 2: Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 */

class Q756 {
    private final static int COUNT = 7;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] lookup = new int[COUNT][COUNT];

        for(String word : allowed) {
            lookup[word.charAt(0)-'A'][word.charAt(1)-'A'] |= 1 << (word.charAt(2)-'A');
        }

        return pyramidTransitionHelper(bottom, bottom.length()-1, 0, "", lookup);
    }

    private boolean pyramidTransitionHelper(String current, int nextLevel, int nextIndex, String next, int[][] lookup) {
        if(nextLevel==1&&nextIndex==1) {
            //completed the pyramid
            return true;
        }
        if(nextIndex==current.length()-1) {
            //completed a layer of pyramid
            return pyramidTransitionHelper(next, nextLevel-1, 0, "", lookup);
        }
        int value = lookup[current.charAt(nextIndex)-'A'][current.charAt(nextIndex+1)-'A'];
        String candidates = "";
        for(int i=0; i<COUNT; i++) {
            if((value & (1 << i))!=0) {
                candidates += (char)('A'+i);
            }
        }
        for(int i=0; i<candidates.length(); i++) {
            char c = candidates.charAt(i);
            if(pyramidTransitionHelper(current, nextLevel, nextIndex+1, next+c, lookup)) {
                return true;
            }
        }
        return false;
    }
}