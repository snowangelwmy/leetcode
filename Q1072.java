/**
 * Test cases:
 * 1: Input: [[0,1],[1,1]]
 * Output: 1
 * Explanation: After flipping no values, 1 row has all values equal.
 * 2: Input: [[0,1],[1,0]]
 * Output: 2
 * Explanation: After flipping values in the first column, both rows have equal values.
 * 3: Input: [[0,0,0],[0,0,1],[1,1,0]]
 * Output: 2
 * Explanation: After flipping values in the first two columns, the last two rows have equal values.
 *
 */

import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

class Q1072 {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    //https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/discuss/373426/Java-Explained-Easy-(Hints-and-Tips)
    int max = 0;
    Map<String, Integer> equalRowsOfAFlip = new HashMap<>();
    for(int[] row : matrix) {
      StringBuilder toZeros = new StringBuilder();
      StringBuilder toOnes = new StringBuilder();
      for(int col : row) {
        if (col == 1) {
          toZeros.append('1');
          toOnes.append('0');
        } else {
          toZeros.append('0');
          toOnes.append('1');
        }
      }
      equalRowsOfAFlip.put(toZeros.toString(), equalRowsOfAFlip.getOrDefault(toZeros.toString(), 0)+1);
      equalRowsOfAFlip.put(toOnes.toString(), equalRowsOfAFlip.getOrDefault(toOnes.toString(), 0)+1);
      max = Math.max(max, Math.max(equalRowsOfAFlip.get(toZeros.toString()), equalRowsOfAFlip.get(toOnes.toString())));
    }
    return max;
  }
}