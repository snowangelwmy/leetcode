/**
 * Test cases:
 * 1: Input: [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * 2: Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * 3: Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 */

class Q1027 {
  public int longestArithSeqLength(int[] A) {
    //Solution: https://leetcode.com/problems/longest-arithmetic-sequence/discuss/385734/Java-DP-easy-to-understand
    //dp[i][j] to be the length of the longest arithmetic subsequence ending with A[i] and A[j]
    int[][] dp = new int[A.length][A.length];

    int maxLen = 0;

    for(int j=0; j<A.length; j++) {
      for(int i=0; i<j; i++) {
        dp[i][j] = 2;

        int diff = A[j] - A[i];
        for(int k=0; k<i; k++) {
          if(A[i]-A[k]==diff) {
            dp[i][j] = Math.max(dp[i][j], 1+dp[k][i]);
          }
        }

        maxLen = Math.max(maxLen, dp[i][j]);
      }
    }

    return maxLen;
  }
}