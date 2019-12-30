/**
 * Test cases:
 * 1: Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 */

import java.util.Arrays;

class Q1130 {
  //https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/398420/Java-DP-Solution-very-easy-to-understand
  public int mctFromLeafValues(int[] arr) {
    if(arr==null||arr.length==0) {
      return 0;
    }

    int N = arr.length;
    //Among all possible binary trees constructed by values from index i to index j, dp[i][j] stores the smallest possible sum of the values of each non-leaf node.
    int[][] dp = new int[N][N];
    for(int i=0; i<N; i++) {
      Arrays.fill(dp[i], -1);
    }
    return dfs(arr, 0, N-1, dp);
  }

  private int dfs(int[] arr, int start, int end, int[][] dp) {
    if(start==end) {
      return 0;
    }
    if(dp[start][end]!=-1) {
      return dp[start][end];
    }
    int min = Integer.MAX_VALUE;
    for(int i=start; i<end; i++) {
      int leftSum = dfs(arr, start, i, dp);
      int rightSum = dfs(arr, i+1, end, dp);
      int largestLeft = Integer.MIN_VALUE;
      for(int j=start; j<=i; j++) {
        largestLeft = Math.max(largestLeft, arr[j]);
      }
      int largetRight = Integer.MIN_VALUE;
      for(int j=i+1; j<=end; j++) {
        largetRight = Math.max(largetRight, arr[j]);
      }
      min = Math.min(min, leftSum + rightSum + largestLeft * largetRight);
    }
    dp[start][end] = min;
    return dp[start][end];
  }
}