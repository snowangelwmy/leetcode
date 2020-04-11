/**
 * Test cases:
 * 1: Input: "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * 2: Input: "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 */

import java.util.Map;
import java.util.HashMap;

class Q657 {

    private static final Map<Character, int[]> DIRECTIONS = new HashMap<Character, int[]>() {{
        put('U', new int[] {-1, 0});
        put('D', new int[] {1, 0});
        put('R', new int[] {0, 1});
        put('L', new int[] {0, -1});
    }};

    public boolean judgeCircle(String moves) {
        if(moves==null||moves.length()==0) {
            return true;
        }

        int initRowIdx = 0;
        int initColIdx = 0;
        int rowIdx = initRowIdx;
        int colIdx = initColIdx;
        for(int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);
            if(!DIRECTIONS.containsKey(c)) {
                return false;
            }

            int[] direction = DIRECTIONS.get(c);
            int nextRowIdx = rowIdx + direction[0];
            int nextColIdx = colIdx + direction[1];
            if(i==moves.length()-1) {
                if(nextRowIdx==initRowIdx&&nextColIdx==initColIdx) {
                    return true;
                } else {
                    return false;
                }
            } else {
                rowIdx = nextRowIdx;
                colIdx = nextColIdx;
            }
        }

        return false;
    }
}