/**
 * Test cases:
 * 1: Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */

class Q289 {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0]==null||board[0].length==0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int liveNeighbors = getLiveNeibors(i, j, board);
                if(board[i][j]==1&&liveNeighbors>=2&&liveNeighbors<=3) {
                    board[i][j] = 3;
                }
                if(board[i][j]==0&&liveNeighbors==3) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getLiveNeibors(int rowIdx, int colIdx, int[][] board) {
        int count = 0;
        int row = board.length;
        int col = board[0].length;
        for(int i=Math.max(rowIdx-1,0); i<=Math.min(rowIdx+1,row-1); i++) {
            for(int j=Math.max(colIdx-1, 0); j<=Math.min(colIdx+1, col-1); j++) {
                count += (board[i][j] & 1);
            }
        }

        count -= (board[rowIdx][colIdx] & 1);
        return count;
    }
}