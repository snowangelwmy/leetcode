/**
 * Test cases:
 * 1: Input:
 * {
 *     {1, 2, 2, 3, 5},
 *     {3, 2, 3, 4, 4},
 *     {2, 4, 5, 3, 1},
 *     {6, 7, 1, 4, 5},
 *     {5, 1, 1, 2, 4}
 * }
 * Output:
 *  [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Q417 {
    public class Coordinate {
        private int rowIdx;
        private int colIdx;

        public Coordinate(int rowIdx, int colIdx) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Coordinate)) {
                return false;
            }

            Coordinate c = (Coordinate) o;

            return rowIdx == c.rowIdx && colIdx == c.colIdx;
        }

        public int hashCode(){
            return rowIdx+colIdx;
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> cells = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return cells;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Coordinate> pacific = new HashSet<>();
        Set<Coordinate> atlantic = new HashSet<>();
        for(int i=0; i<row; i++) {
            pacific.add(new Coordinate(i, 0));
            atlantic.add(new Coordinate(i, col-1));
        }
        for(int j=0; j<col; j++) {
            pacific.add(new Coordinate(0, j));
            atlantic.add(new Coordinate(row-1, j));
        }

        bfs(pacific, matrix);
        bfs(atlantic, matrix);
        pacific.retainAll(atlantic);
        List<int[]> coords = new ArrayList<>(pacific.size());
        for(Coordinate coord : pacific) {
            coords.add(new int[]{coord.rowIdx, coord.colIdx});
        }
        return coords;
    }

    private void bfs(Set<Coordinate> cells, int[][] matrix) {
        Queue<Coordinate> coords = new LinkedList<>(cells);
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = matrix.length;
        int col = matrix[0].length;
        while(coords.size()>0) {
            Coordinate coord = coords.poll();
            for(int i=0; i<directions.length; i++) {
                Coordinate newCoord = new Coordinate(coord.rowIdx+directions[i][0], coord.colIdx+directions[i][1]);
                if(newCoord.rowIdx>=0&&newCoord.rowIdx<row
                        &&newCoord.colIdx>=0&&newCoord.colIdx<col
                        &&!cells.contains(newCoord)
                        &&matrix[newCoord.rowIdx][newCoord.colIdx]>=matrix[coord.rowIdx][coord.colIdx]) {
                    coords.add(newCoord);
                    cells.add(newCoord);
                }
            }
        }
    }
}