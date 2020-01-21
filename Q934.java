/**
 * Test cases:
 * 1: Input: [[0,1],[1,0]]
 * Output: 1
 * 2: Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * 3: Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

class Q934 {

    int[][] diffs = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    class Node {
        int row;
        int col;
        int distance;

        Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int shortestBridge(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        int[][] colors = new int[row][col];

        findIslands(A, row, col, colors);

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> target = new HashSet();
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(colors[i][j]==1) {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                } else if(colors[i][j]==2) {
                    target.add(i*row+j);
                }
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(target.contains(node.row*row+node.col)) {
                return node.distance - 1;
            }

            for(int[] diff : diffs) {
                int newRow = node.row + diff[0];
                int newCol = node.col + diff[1];

                if(newRow>=0&&newRow<row&&newCol>=0&&newCol<col&&!visited[newRow][newCol]) {
                    queue.offer(new Node(newRow, newCol, node.distance+1));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }

    private void findIslands(int[][] A, int row, int col, int[][] colors) {
        int color = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(A[i][j]==1&&colors[i][j]==0) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i*row+j);
                    colors[i][j] = ++color;
                    while(!stack.isEmpty()) {
                        int value = stack.pop();
                        int rowIndex = value/row;
                        int colIndex = value%row;
                        for(int[] diff: diffs) {
                            int newRowIndex = rowIndex + diff[0];
                            int newColIndex = colIndex + diff[1];

                            if(newRowIndex>=0&&newRowIndex<row&&newColIndex>=0&&newColIndex<col&&A[newRowIndex][newColIndex]==1&&colors[newRowIndex][newColIndex]==0) {
                                stack.push(newRowIndex*row+newColIndex);
                                colors[newRowIndex][newColIndex] = color;
                            }
                        }
                    }
                }
            }
        }
    }
}