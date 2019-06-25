/**
 * Test cases:
 * 1: Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

import java.lang.Math;

class Q64 {
  public int minPathSum(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int[][] memo = new int[row][col];
    int minSum = minPathSumHelper(grid, 0, 0, row-1, col-1, memo);
    return minSum;
  }

  private int minPathSumHelper(int[][] grid, int startRow, int startCol, int endRow, int endCol, int[][] memo) {
    if(memo[startRow][startCol]!=0) {
      return memo[startRow][startCol];
    }
    if(startRow==endRow&&startCol==endCol) {
      memo[startRow][startCol] = grid[endRow][endCol];
      return grid[endRow][endCol];
    }
    int minSum = Integer.MAX_VALUE;
    //move down if possible
    if(startRow<endRow) {
      int curSum = grid[startRow][startCol] + minPathSumHelper(grid, startRow+1, startCol, endRow, endCol, memo);
      minSum = Math.min(minSum, curSum);
    }
    //move right if possible
    if(startCol<endCol) {
      int curSum = grid[startRow][startCol] + minPathSumHelper(grid, startRow, startCol+1, endRow, endCol, memo);
      minSum = Math.min(minSum, curSum);
    }
    memo[startRow][startCol] = minSum;
    return minSum;
  }
}
