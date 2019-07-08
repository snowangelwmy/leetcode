/**
 * Test cases:
 * 1: Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

class Q59 {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int x = 0;
    int y = 0;
    int dx = 0;
    int dy = 1;
    int round = 0;
    for(int i=1; i<=n*n; i++) {
      matrix[x][y] = i;
      x += dx;
      y += dy;
      if(x==round&&y==n-1-round) {//top right corner
        dx=1;
        dy=0;
      } else if(x==n-1-round&&y==n-1-round) {//bottom right corner
        dx=0;
        dy=-1;
      } else if(x==n-1-round&&y==round) {//bottom left corner
        dx=-1;
        dy=0;
      } else if(x==round+1&&y==round) {//top left corner
        dx=0;
        dy=1;
        round++;
      }
    }
    return matrix;
  }
}