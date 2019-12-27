/**
 * Test cases:
 * 1: Input: "bbbab"
 * Output: 4
 * 2: Input: "cbbd"
 * Output: 2
 */

class Q516 {
  //https://leetcode.com/problems/longest-palindromic-subsequence/discuss/417356/Java-DP-Solutions-with-Graphs!
  public int longestPalindromeSubseq(String s) {
    if(s==null||s.length()==0) {
      return 0;
    }
    if(s.length()==1) {
      return 1;
    }

    int N = s.length();
    //the longest palindromic subsequence's length in s between i and j
    int[][] dp = new int[N][N];
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(i>j) {
          dp[i][j] = 0;
        } else if(i==j) {
          dp[i][j] = 1;
        }
      }
    }

    for(int i=N-2; i>=0; i--) {
      for(int j=i+1; j<N; j++) {
        if(s.charAt(i)==s.charAt(j)) {
          dp[i][j] = 2 + dp[i+1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
      }
    }

    return dp[0][N-1];
  }
}