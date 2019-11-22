/**
 * Test cases:
 * 1: Input:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * 2: Input:
 * [[0,0,0,0,0,0,0,0]]
 * Output: 0
 */

class Q695 {
  public int maxAreaOfIsland(int[][] grid) {
    if(grid==null||grid[0].length==0||grid[0]==null||grid[0].length==0) {
      return 0;
    }

    int maxArea = 0;
    for(int i=0; i<grid.length; i++) {
      for(int j=0; j<grid[0].length; j++) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        maxArea = Math.max(maxArea, calculateArea(i, j, grid, seen));
      }
    }
    return maxArea;
  }

  private int calculateArea(int row, int col, int[][] grid, boolean[][] seen) {
    if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]==0||seen[row][col]) {
      return 0;
    }

    seen[row][col] = true;
    return 1 + calculateArea(row+1,col,grid,seen) + calculateArea(row-1,col,grid,seen)
            + calculateArea(row,col+1,grid,seen) + calculateArea(row,col-1,grid,seen);
  }
}