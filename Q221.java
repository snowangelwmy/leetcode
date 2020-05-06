/**
 * Test cases:
 * 1: Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Output: 4
 */

class Q221 {
    //https://leetcode.com/problems/maximal-square/solution/
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int maxSquareLen = 0;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if(matrix[i-1][j-1]=='1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }

        return maxSquareLen * maxSquareLen;
    }
}