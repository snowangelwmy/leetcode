/**
 * Test cases:
 * 1: Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * 2: Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 */

import java.util.Queue;
import java.util.LinkedList;

class Q542 {
    class CellInfo {
        int rowIdx;
        int colIdx;
        int distance;
        public CellInfo(int rowIdx, int colIdx, int distance) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return null;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] distances = new int[row][col];
        Queue<CellInfo> queue = new LinkedList<>();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j]==0) {
                    distances[i][j] = 0;
                    queue.offer(new CellInfo(i, j, 0));
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()) {
            CellInfo cell = queue.poll();
            int rowIdx = cell.rowIdx;
            int colIdx = cell.colIdx;
            int distance = cell.distance;
            //up
            if(rowIdx-1>=0&&matrix[rowIdx-1][colIdx]==1&&distances[rowIdx-1][colIdx]>distance+1) {
                distances[rowIdx-1][colIdx] = distance+1;
                queue.offer(new CellInfo(rowIdx-1, colIdx, distance+1));
            }
            //down
            if(rowIdx+1<row&&matrix[rowIdx+1][colIdx]==1&&distances[rowIdx+1][colIdx]>distance+1) {
                distances[rowIdx+1][colIdx] = distance+1;
                queue.offer(new CellInfo(rowIdx+1, colIdx, distance+1));
            }
            //left
            if(colIdx-1>=0&&matrix[rowIdx][colIdx-1]==1&&distances[rowIdx][colIdx-1]>distance+1) {
                distances[rowIdx][colIdx-1] = distance+1;
                queue.offer(new CellInfo(rowIdx, colIdx-1, distance+1));
            }
            //right
            if(colIdx+1<col&&matrix[rowIdx][colIdx+1]==1&&distances[rowIdx][colIdx+1]>distance+1) {
                distances[rowIdx][colIdx+1] = distance+1;
                queue.offer(new CellInfo(rowIdx, colIdx+1, distance+1));
            }
        }
        return distances;
    }
}