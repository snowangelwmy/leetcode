/**
 * Test cases:
 * 1: Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 */

import java.util.Arrays;

class Q646 {
  public int findLongestChain(int[][] pairs) {
    if(pairs==null||pairs.length==0) {
      return 0;
    }

    Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
    int N = pairs.length;
    int[] dp = new int[N];
    Arrays.fill(dp, 1);

    for(int j=1; j<N; j++) {
      for(int i=0; i<j; i++) {
        if(pairs[i][1]<pairs[j][0]) {
          dp[j] = Math.max(dp[j], dp[i]+1);
        }
      }
    }

    int max = 0;
    for(int i=0; i<N; i++) {
      max = Math.max(dp[i], max);
    }

    return max;
  }
}