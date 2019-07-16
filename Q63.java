/**
 * Test cases:
 * 1: Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 2: Input:
 * [
 *   [0],
 *   [1]
 * ]
 * Output: 0
 */

class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0]==null||obstacleGrid[0].length==0||obstacleGrid[0][0]==1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;

        for(int i=1; i<row; i++) { //the first column
            if(obstacleGrid[i][0]==0) {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            } else {
                obstacleGrid[i][0] = 0;
            }
        }

        for(int i=1; i<col; i++) { //the first row
            if(obstacleGrid[0][i]==0) {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            } else {
                obstacleGrid[0][i] = 0;
            }
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(obstacleGrid[i][j]==0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row-1][col-1];
    }
}