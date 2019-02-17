/**
 * Test cases:
 * 1: Input:
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * Output: [2]
 * Explanation:
 * If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 * 2: Input:
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * Output: [0,0]
 * Explanation:
 * When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 * 3: Input:
 * grid = [[1],[1],[1],[1],[1]]
 * hits = [[3,0],[4,0],[1,0],[2,0],[0,0]]
 * Output: [1,0,1,0,0]
 */

import java.util.Arrays;

class Q803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //final state
        int[][] A = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                A[i][j] = grid[i][j];
            }
        }
        for(int[] hit : hits) {
            A[hit[0]][hit[1]] = 0;
        }
        DSU dsu = new DSU(row*col+1);
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(A[i][j]==0) {
                    continue;
                }
                if(i==0) {
                    dsu.union(i*col+j, row*col);
                }
                if(i>0&&A[i-1][j]==1) {
                    dsu.union((i-1)*col+j, i*col+j);
                }
                if(j>0&&A[i][j-1]==1) {
                    dsu.union(i*col+(j-1), i*col+j);
                }
            }
        }

        int[] bricks = new int[hits.length];
        for(int i=hits.length-1; i>=0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y]==0) {
                continue;
            }
            int preTop = dsu.top();
            A[x][y] = 1;
            for(int j=0; j<dxy.length; j++) {
                int dx = x + dxy[j][0];
                int dy = y + dxy[j][1];
                if(dx>=0&&dx<row&&dy>=0&&dy<col&&A[dx][dy]==1) {
                    dsu.union(x*col+y, dx*col+dy);
                }
            }
            if(x==0) {
                dsu.union(x*col+y, row*col);
            }
            bricks[i] = Math.max(0, dsu.top() - preTop - 1);
        }
        return bricks;
    }

    public class DSU {
        private int[] parents;
        private int[] ranks;
        private int[] sizes;

        public DSU(int size) {
            parents = new int[size];
            for(int i=0; i<size; i++) {
                parents[i] = i;
            }
            ranks = new int[size];
            sizes = new int[size];
            Arrays.fill(sizes, 1);
        }

        public int find(int x) {
            if(parents[x]!=x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px==py) {
                return;
            }

            if(ranks[px]>ranks[py]) {
                parents[py] = px;
                sizes[px] += sizes[py];
            } else if(ranks[px]<ranks[py]) {
                parents[px] = py;
                sizes[py] += sizes[px];
            } else {//ranks[px]=ranks[py]
                parents[py] = px;
                ranks[px]++;
                sizes[px] += sizes[py];
            }
        }

        public int top() {
            return sizes[find(sizes.length-1)]-1;
        }
    }
}