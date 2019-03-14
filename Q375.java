/**
 * Test cases:
 * 1: Input: n = 10
 * Output: 16
 */

public class Q375 {

  public int getMoneyAmount(int n) {
    int[][] lookup = new int[n+1][n+1];
    return dp(lookup, 1, n);
  }

  private int dp(int[][] lookup, int low, int high) {
    if(low>=high) return 0;
    if(lookup[low][high] != 0) return lookup[low][high];
    int result = Integer.MAX_VALUE;
    for(int i=low; i<=high; i++) {
      int amount = i + Math.max(dp(lookup, low, i-1), dp(lookup, i+1, high));
      result = Math.min(result, amount);
    }
    lookup[low][high] = result;
    return result;
  }

}
