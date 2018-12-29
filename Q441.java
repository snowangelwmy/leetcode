/**
 * Test cases:
 * 1: Input & Output:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * 2: Input & Output:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */

class Solution {
  public int arrangeCoins(int n) {
    if(n<0){
      return -1;
    } else if(n==0) {
      return 0;
    } else {//n>0
      int rowCount = 0;
      for(long i=1; i<=n; i++){
        rowCount++;
        n -= i;
      }
      return rowCount;
    }
  }
}