/**
 * Test cases:
 * 1: Input:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * Output:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */

class Q130 {
    private static final char TEMP = 'T';

    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0]==null||board[0].length==0) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board[0].length; i++) {
            if(board[0][i]=='O') {
                dfs(0, i, board, visited);
            }
            if(board[board.length-1][i]=='O') {
                dfs(board.length-1, i, board, visited);
            }
        }
        for(int i=0; i<board.length; i++) {
            if(board[i][0]=='O') {
                dfs(i, 0, board, visited);
            }
            if(board[i][board[0].length-1]=='O') {
                dfs(i, board[0].length-1, board, visited);
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='T') {
                    board[i][j] = 'O';
                } else if(board[i][j]=='O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        if(row<0||row>=rows||col<0||col>=cols||visited[row][col]||board[row][col]!='O') {
            return;
        }
        visited[row][col] = true;
        board[row][col]=TEMP;
        dfs(row-1, col, board, visited);
        dfs(row+1, col, board, visited);
        dfs(row, col-1, board, visited);
        dfs(row, col+1, board, visited);
    }
}