/**
 * Test cases:
 * 1: Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 */

class Q498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int[][] directions = {{-1, 1}, {1, -1}};
        int rowIdx = 0;
        int colIdx = 0;
        int dirIdx = 0;
        for(int i=0; i<rows*cols; i++) {
            res[i] = matrix[rowIdx][colIdx];
            rowIdx += directions[dirIdx][0];
            colIdx += directions[dirIdx][1];

            if (rowIdx>=rows) {//out of bottom border
                rowIdx = rows - 1;
                colIdx += 2;
                dirIdx = 1 - dirIdx;
            }
            else if (colIdx>=cols) { //out of right border
                colIdx = cols - 1;
                rowIdx += 2;
                dirIdx = 1 - dirIdx;
            } else if (rowIdx<0) {//out of top border
                rowIdx = 0;
                dirIdx = 1 - dirIdx;
            } else if (colIdx<0) {//out of left border
                colIdx = 0;
                dirIdx = 1 - dirIdx;
            }
        }
        return res;
    }
}