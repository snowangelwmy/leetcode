/**
 * Test cases:
 * 1: Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 2: Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.List;
import java.util.ArrayList;

class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return new ArrayList<Integer>();
        }

        List<Integer> nums = new ArrayList<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[][] seen = new boolean[rowLen][colLen];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = 0;
        int col = 0;
        int dirIdx = 0;
        for(int i=0; i<rowLen*colLen; i++) { //it controls when to stop iteration
            nums.add(matrix[row][col]);
            seen[row][col] = true;
            int nextRow = row + dr[dirIdx];
            int nextCol = col + dc[dirIdx];
            if(nextRow>=0&&nextRow<rowLen&&nextCol>=0&&nextCol<colLen&&!seen[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                dirIdx = (dirIdx + 1) % 4;
                row = row + dr[dirIdx];
                col = col + dc[dirIdx];
            }
        }
        return nums;
    }
}