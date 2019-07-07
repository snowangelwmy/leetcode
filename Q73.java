/**
 * Test cases:
 * 1: Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 2: Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */

class Q73 {

    //O(1) pace
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        //matrix[0][0] to indicate if any zero in first row
        boolean hasZeroFirstCol = false; //if any zero in the first col
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    if(j==0) {
                        hasZeroFirstCol = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0) {//has 0 in first row
            for(int j=0; j<col; j++) {
                matrix[0][j]=0;
            }
        }

        if(hasZeroFirstCol) {//has 0 in first col
            for(int i=0; i<row; i++) {
                matrix[i][0]=0;
            }
        }
    }

    //O(m+n) pace
    public void setZeroes0(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] isZeroRow = new boolean[row];
        boolean[] isZeroCol = new boolean[col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j]==0) {
                    isZeroRow[i] = true;
                    isZeroCol[j] = true;
                }
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(isZeroRow[i] || isZeroCol[j]) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}