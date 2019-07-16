/**
 * Test cases:
 * 1: Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 2: Input: m = 7, n = 3
 * Output: 28
 */

class Q62 {
    public int uniquePaths(int m, int n) {
        int[][] counts = new int[m][n];
        for(int i=0; i<n; i++) {
            counts[0][i] = 1; //the first row
        }
        for(int i=0; i<m; i++) {
            counts[i][0] = 1; //the first column
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                counts[i][j] = counts[i-1][j] + counts[i][j-1];
            }
        }
        return counts[m-1][n-1];
    }
}