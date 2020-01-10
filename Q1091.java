/**
 * Test cases:
 * 1: Input: [[0,1],[1,0]]
 * 0 1
 * 1 0
 * Output: 2
 * Explanation: The shortest path is: [0, 0] -> [1, 1]
 * 2: [[0,0,0],[1,1,0],[1,1,0]]
 * 0 0 0
 * 1 1 0
 * 1 1 0
 * Output: 4
 * Explanation: The shortest path is: [0, 0] -> [0, 1] -> [1, 2] -> [2, 2]
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Q1091 {

    private static final int[][] diffs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {1, 1},
            {-1, -1},
            {-1, 1},
            {1, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;

        int[] start = {0, 0};
        int[] end = {row-1, col-1};

        if(grid[start[0]][start[1]]==1||grid[end[0]][end[1]]==1) {
            return -1;
        }

        int[][] visited = new int[row][col];
        for(int i=0; i<row; i++) {
            Arrays.fill(visited[i], -1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(row*col, new NodeComparator());
        queue.offer(new Node(start[0], start[1], 1));
        visited[start[0]][start[1]] = 1;
        int shortestDistance = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.rowIndex==end[0]&&cur.colIndex==end[1]) {
                shortestDistance = Math.min(shortestDistance, cur.distance);
                continue;
            }

            for(int i=0; i<diffs.length; i++) {
                int nextRowIndex = cur.rowIndex + diffs[i][0];
                int nextColIndex = cur.colIndex + diffs[i][1];
                int nextDistance = cur.distance + 1;
                if(nextRowIndex>=0&&nextRowIndex<row&&nextColIndex>=0&&nextColIndex<col&&grid[nextRowIndex][nextColIndex]==0) {
                    if(visited[nextRowIndex][nextColIndex]==-1||visited[nextRowIndex][nextColIndex]>nextDistance) {
                        queue.offer(new Node(nextRowIndex, nextColIndex, nextDistance));
                        visited[nextRowIndex][nextColIndex] = nextDistance;
                    }
                }
            }
        }

        return shortestDistance==Integer.MAX_VALUE? -1 : shortestDistance;
    }

    class Node {
        int rowIndex;
        int colIndex;
        int distance;

        public Node(int rowIndex, int colIndex, int distance) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.distance = distance;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            if(node1.distance<node2.distance) {
                return -1;
            } else if(node1.distance>node2.distance) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}