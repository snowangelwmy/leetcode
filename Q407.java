/**
 * Test cases:
 * 1: Input: Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * Output: 4
 */

import java.util.PriorityQueue;
import java.util.Comparator;

class Q407 {

    public class Cell {
        private int rowIdx;
        private int colIdx;
        private int height;

        public Cell(int rowIdx, int colIdx, int height) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0||heightMap[0]==null||heightMap[0].length==0) {
            return 0;
        }

        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<Cell> nodes = new PriorityQueue<>(1, new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        boolean[][] visited = new boolean[row][col];

        //add all boundary cells as the initial boundary
        for(int i=0; i<row; i++) {
            visited[i][0] = true;
            visited[i][col-1] = true;
            nodes.add(new Cell(i, 0, heightMap[i][0]));
            nodes.add(new Cell(i, col-1, heightMap[i][col-1]));
        }
        for(int j=0; j<col; j++) {
            visited[0][j] = true;
            visited[row-1][j] = true;
            nodes.add(new Cell(0, j, heightMap[0][j]));
            nodes.add(new Cell(row-1, j, heightMap[row-1][j]));
        }

        int[][] dxy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int volume = 0;
        while(!nodes.isEmpty()) {
            Cell cell = nodes.poll();
            for(int i=0; i<dxy.length; i++) {
                int nextRowIdx = cell.rowIdx + dxy[i][0];
                int nextColIdx = cell.colIdx + dxy[i][1];
                if(nextRowIdx>=0 && nextRowIdx<row && nextColIdx>=0 && nextColIdx< col && !visited[nextRowIdx][nextColIdx]) {
                    visited[nextRowIdx][nextColIdx] = true;
                    volume += Math.max(0, cell.height - heightMap[nextRowIdx][nextColIdx]);
                    nodes.add(new Cell(nextRowIdx, nextColIdx, Math.max(cell.height, heightMap[nextRowIdx][nextColIdx])));
                }
            }
        }
        return volume;
    }
}