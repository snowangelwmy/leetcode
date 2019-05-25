/**
 * Test cases:
 * 1: Input & Output: board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 2: Input & Output: board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','E','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCESEEEFS", return true.
 */

class Q79 {
    //approach 2: visited matrix to remember if an element has been visited before.
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0]==null||board[0].length==0||word==null) {
            return false;
        }

        char[] wordChars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(exist(board, i, j, wordChars, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, char[] chars, int idx, boolean[][] visited) {
        if(idx==chars.length) { return true; }
        if(row<0||col<0||row==board.length||col==board[0].length) { return false; }
        if(board[row][col]!=chars[idx]||visited[row][col]) {
            return false;
        } else {
            visited[row][col] = true;
            boolean exist = exist(board, row+1, col, chars, idx+1, visited) ||
                    exist(board, row-1, col, chars, idx+1, visited) ||
                    exist(board, row, col+1, chars, idx+1, visited) ||
                    exist(board, row, col-1, chars, idx+1, visited);
            visited[row][col] = false;
            return exist;
        }
    }

    //approach 1: original matrix to remember if an element has been visited before.
    public boolean exist0(char[][] board, String word) {
        if(board==null||board.length==0||board[0]==null||board[0].length==0||word==null) {
            return false;
        }

        char[] wordChars = word.toCharArray();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(exist(board, i, j, wordChars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, char[] chars, int idx) {
        if(idx==chars.length) { return true; }
        if(row<0||col<0||row==board.length||col==board[0].length) { return false; }
        if(board[row][col]!=chars[idx]) { return false; }
        board[row][col] ^= 256;
        boolean exist = exist(board, row+1, col, chars, idx+1) ||
                exist(board, row-1, col, chars, idx+1) ||
                exist(board, row, col+1, chars, idx+1) ||
                exist(board, row, col-1, chars, idx+1);
        board[row][col] ^= 256;
        return exist;
    }
}