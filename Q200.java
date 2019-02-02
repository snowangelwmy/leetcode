/**
 * Test cases:
 * 1: Input:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * 2: Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */

class Q200 {
    private int[] dx = {-1, 0, 0, +1};
    private int[] dy = {0, -1, +1, 0};

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0) {
            return islandCount;
        }
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    expandIsland(i, j, grid);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void expandIsland(int rowIdx, int colIdx, char[][] grid) {
        for(int i=0; i<dx.length; i++) {
            int dRowIdx = rowIdx+dx[i];
            int dColIdx = colIdx+dy[i];
            if(dRowIdx>=0&&dRowIdx<grid.length&&dColIdx>=0&&dColIdx<grid[0].length) {
                if(grid[dRowIdx][dColIdx]=='1') {
                    //you cannot change the order of the following 2 statements,
                    // otherwise, it will cause stackOverflow. Can you think of why?
                    grid[dRowIdx][dColIdx] = 'X';
                    expandIsland(dRowIdx, dColIdx, grid);
                }
            }
        }
    }
}