/**
 * Test cases:
 * 1: Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 * 2: Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 * 3: Input: [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
 * Output: -1
 * 4: Input: [[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * Output: -1
 */

class Q1162 {
    private static final int MAX_DISTANCE = 201;
    //https://leetcode.com/problems/as-far-from-land-as-possible/discuss/422691/7ms-DP-solution-with-example-beats-100
    public int maxDistance(int[][] grid) {
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j]==1) {
                    continue;
                }
                grid[i][j] = MAX_DISTANCE;
                if(i>0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j]+1);
                if(j>0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1]+1);
            }
        }

        int max = 0;
        for(int i=row-1; i>=0; i--) {
            for(int j=col-1; j>=0; j--) {
                if(grid[i][j]==1) {
                    continue;
                }
                if(i<=row-2) grid[i][j] = Math.min(grid[i][j], grid[i+1][j]+1);
                if(j<=row-2) grid[i][j] = Math.min(grid[i][j], grid[i][j+1]+1);
                max = Math.max(max, grid[i][j]);
            }
        }

        return max==MAX_DISTANCE ? -1 : max-1;
    }
}