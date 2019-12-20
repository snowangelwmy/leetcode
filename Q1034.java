/**
 * Test cases:
 * 1: Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * Output: [[3, 3], [3, 2]]
 * 2: Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * Output: [[1, 3, 3], [2, 3, 3]]
 * 3: Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 */

import java.util.List;
import java.util.ArrayList;

class Q1034 {
  public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    List<int[]> boards = new ArrayList<>();

    dfs(grid, r0, c0, grid[r0][c0], boards, new boolean[grid.length][grid[0].length]);

    for(int[] square : boards) {
      grid[square[0]][square[1]] = color;
    }

    return grid;
  }

  private void dfs(int[][] grid, int r0, int c0, int color, List<int[]> boards, boolean[][] visited) {
    if(r0<0 || c0<0 || r0>=grid.length || c0>=grid[0].length || grid[r0][c0]!=color || visited[r0][c0]) {
      return;
    }

    visited[r0][c0] = true;
    if(isBoard(grid, r0, c0, color)) { boards.add(new int[]{r0, c0}); }

    dfs(grid, r0-1, c0, color, boards, visited);
    dfs(grid, r0+1, c0, color, boards, visited);
    dfs(grid, r0, c0-1, color, boards, visited);
    dfs(grid, r0, c0+1, color, boards, visited);
  }

  private boolean isBoard(int[][] grid, int r0, int c0, int color) {
    if(r0==0 || c0==0 || r0==grid.length-1 || c0==grid[0].length-1) {
      return true;
    }

    return grid[r0-1][c0]!=color || grid[r0+1][c0]!=color || grid[r0][c0-1]!=color || grid[r0][c0+1]!=color;
  }
}