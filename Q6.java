/**
 * Test cases:
 * 1: Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Explanation:
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 2: Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.lang.Math;

class Q6 {
    public String convert(String s, int numRows) {
        if(numRows<=1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0; i<Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curIdx = 0;
        boolean goDown = false;
        for(char c : s.toCharArray()) {
            rows.get(curIdx).append(c);
            if(curIdx == 0 || curIdx == numRows-1) goDown = !goDown;
            curIdx += goDown? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return  res.toString();
    }
}