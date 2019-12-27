/**
 * Test cases:
 * 1: Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 2: Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

class Q91 {
  //https://leetcode.com/problems/decode-ways/discuss/455948/Java-easy-DP-solution
  public int numDecodings(String s) {
    if(s==null||s.length()==0) {
      return 0;
    }

    int[] dp = new int[s.length()+1];
    dp[0] = 1;
    dp[1] = isOneEncoding(s.charAt(0)) ? 1 : 0;

    for(int i=2; i<=s.length(); i++) {
      boolean isOneEncoding = isOneEncoding(s.charAt(i-1));
      boolean isTwoEncoding = isTwoEncoding(s.charAt(i-2), s.charAt(i-1));
      if(isOneEncoding && isTwoEncoding)
        dp[i] = dp[i-1] + dp[i-2];
      else if(!isOneEncoding && isTwoEncoding)
        dp[i] = dp[i-2];
      else if(isOneEncoding && !isTwoEncoding)
        dp[i] = dp[i-1];
      else //!isOneEncoding && !isTwoEncoding
        return 0;
    }

    return dp[s.length()];
  }

  private boolean isOneEncoding(char c) {
    if(c>='1' && c<='9') {
      return true;
    }
    return false;
  }

  private boolean isTwoEncoding(char c1, char c2) {
    if(c1=='1' && (c2>='0' && c2<='9')) {
      return true;
    }
    if(c1=='2' && (c2>='0' && c2<='6')) {
      return true;
    }

    return false;
  }
}