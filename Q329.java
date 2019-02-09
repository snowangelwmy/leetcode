/**
 * Test cases:
 * 1: Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * 2: Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */

class Q329 {
    private static int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int longestPath = 1;
        int[][] lookup = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, lookup));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int rowIdx, int colIdx, int[][] lookup) {
        if(lookup[rowIdx][colIdx]!=0) {
            return lookup[rowIdx][colIdx];
        }
        int longestPath = 1;
        for(int i=0; i<directions.length; i++) {
            int newRowIdx = rowIdx + directions[i][0];
            int newColIdx = colIdx + directions[i][1];
            if(newRowIdx>=0&&newRowIdx<matrix.length&&
                    newColIdx>=0&&newColIdx<matrix[0].length&&
                    matrix[newRowIdx][newColIdx]>matrix[rowIdx][colIdx]) {
                longestPath = Math.max(longestPath, dfs(matrix, newRowIdx, newColIdx, lookup)+1);
            }
        }
        lookup[rowIdx][colIdx] = longestPath;
        return lookup[rowIdx][colIdx];
    }
}