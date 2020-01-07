/**
 * Test cases:
 * 1: Input:
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 * Click : [3,0]
 * Output:
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *  2: Input:
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 * Click : [1,2]
 * Output:
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 */

class Q529 {
    private static final int[][] diffes = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {-1, -1},
            {1, 1},
            {-1, 1},
            {1, -1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board==null||board.length==0||board[0]==null||board[0].length==0||click==null||click.length<2) {
            return board;
        }

        int row = click[0];
        int col = click[1];

        if(board[row][col]!='M'&&board[row][col]!='E') {
            return board;
        }

        if(board[row][col]=='M') {
            board[row][col] = 'X';
            return board;
        } else {
            //board[row][col]=='E'
            boolean[][] visited = new boolean[board.length][board[0].length];
            dfs(board, row, col, visited);
        }
        return board;
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        if(!withinBoard(board, row, col)||visited[row][col]||board[row][col]!='E') {
            return;
        }

        board[row][col] = getNextCharForE(board, row, col);
        visited[row][col] = true;
        if(board[row][col]!='B') {
            return;
        }

        for(int[] diff : diffes) {
            int neighborRow = row+diff[0];
            int neighborCol = col+diff[1];
            dfs(board, neighborRow, neighborCol, visited);
        }
    }

    private char getNextCharForE(char[][] board, int row, int col) {
        int numOfMines = getNumOfMines(board, row, col);
        if(numOfMines==0) {
            return 'B';
        } else {
            return (char)(numOfMines+'0');
        }
    }

    private int getNumOfMines(char[][] board, int row, int col) {
        int mines = 0;

        for(int[] diff : diffes) {
            int neighborRow = row+diff[0];
            int neighborCol = col+diff[1];
            if(withinBoard(board, neighborRow, neighborCol) && isMine(board, neighborRow, neighborCol)) {
                mines++;
            }
        }

        return mines;
    }

    private boolean withinBoard(char[][] board, int row, int col) {
        if(row>=0&&row<board.length&&col>=0&&col<board[0].length) {
            return true;
        }

        return false;
    }

    private boolean isMine(char[][] board, int row, int col) {
        return board[row][col]=='M'||board[row][col]=='X';
    }
}