/**
 * Test cases:
 * 1: Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * 2: Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * 3: Input: grid = [[1,0,7,0,0,0],[2,0,6,0,1,0],[3,5,6,7,4,2],[4,3,1,0,2,0],[3,0,5,0,20,0]]
 * Output: 60
 * Explanation:
 * [[1,0,7,0,0,0],
 *  [2,0,6,0,1,0],
 *  [3,5,6,7,4,2],
 *  [4,3,1,0,2,0],
 *  [3,0,5,0,20,0]
 * ]
 * Path to get the maximum gold, 20 -> 2 -> 4 -> 7 -> 6 -> 5 -> 3 -> 4 -> 3 -> 1 -> 5.
 */

import java.util.Arrays;

class Q1219 {

    private static final int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int getMaximumGold(int[][] grid) {
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0) {
            return 0;
        }

        int maxGold = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j]!=0) {
                    resetGrid(visited);
                    int curGold = getGold(grid, i, j, visited);
                    System.out.println("i:"+i+"j:"+j+"curGold:"+curGold);
                    maxGold = Math.max(maxGold, curGold);
                }
            }
        }

        return maxGold;
    }

    private int getGold(int[][] grid, int rowIdx, int colIdx, int[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        if(rowIdx<0||rowIdx>=row||colIdx<0||colIdx>=col||grid[rowIdx][colIdx]==0||visited[rowIdx][colIdx]!=0) {
            return 0;
        }

        int gold = grid[rowIdx][colIdx];
        visited[rowIdx][colIdx] = 1;
        for(int[] direction : directions) {
            int newRowIdx = rowIdx + direction[0];
            int newColIdx = colIdx + direction[1];
            gold = Math.max(gold, grid[rowIdx][colIdx]+getGold(grid, newRowIdx, newColIdx, visited));
        }
        visited[rowIdx][colIdx] = 0;

        return gold;
    }

    private void resetGrid(int[][] grid) {
        int row = grid.length;
        for(int i=0; i<row; i++) {
            Arrays.fill(grid[i], 0);
        }
    }
}