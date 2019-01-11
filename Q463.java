/**
 * Test cases:
 * 1: Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * Output: 16
 */

class Q463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0){
            return perimeter;
        }
        int island = 0;
        int neighbors = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    island++;
                    if(i-1>=0 && grid[i-1][j]==1) {
                        neighbors++;
                    }
                    if(i+1<grid.length && grid[i+1][j]==1) {
                        neighbors++;
                    }
                    if(j-1>=0 && grid[i][j-1]==1) {
                        neighbors++;
                    }
                    if(j+1<grid[i].length && grid[i][j+1]==1) {
                        neighbors++;
                    }
                }
            }
        }
        perimeter = 4*island - neighbors;
        return perimeter;
    }
}