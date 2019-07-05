/**
 * Test cases:
 * 1: Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 2: Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */

class Q36 {
  public boolean isValidSudoku(char[][] board) {
    if(board==null||board.length!=9||board[0]==null||board[0].length!=9) {
      return false;
    }

    int size = 9;
    //check if each row contains the digits 1-9 without repetition.
    for(int i=0; i<size; i++) {
      boolean[] nums = new boolean[9];
      for(int j=0; j<size; j++) {
        System.out.println(i+","+j);
        if(board[i][j]!='.') {
          int numIdx = board[i][j]-'0'-1;
          if(nums[numIdx]) {
            return false;
          }
          nums[numIdx] = true;
        }
      }
    }

    //check if each column must contain the digits 1-9 without repetition.
    for(int i=0; i<size; i++) {
      boolean[] nums = new boolean[9];
      for(int j=0; j<size; j++) {
        if(board[j][i]!='.') {
          int numIdx = board[j][i]-'0'-1;
          if(nums[numIdx]) {
            return false;
          }
          nums[numIdx] = true;
        }
      }
    }

    //check if each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    for(int i=0; i<size; i++) {
      boolean[] nums = new boolean[9];
      for(int j=0; j<size; j++) {
        int rowIdx = i/3 * 3 + j/3 * 1;
        int colIdx = i%3 * 3 + j%3 * 1;
        if(board[rowIdx][colIdx]!='.') {
          int numIdx = board[rowIdx][colIdx]-'0'-1;
          if(nums[numIdx]) {
            return false;
          }
          nums[numIdx] = true;
        }
      }
    }

    return true;
  }
}