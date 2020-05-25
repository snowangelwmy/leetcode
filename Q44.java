/**
 * Test cases:
 * 1: Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 2: Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * 3: Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * 4: Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * 5: Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * 6: Input:
 * s = "ho"
 * p = "ho**"
 * Output: true
 */

class Q44 {
    public boolean isMatch(String s, String p) {
        if(s==null&&p==null) {
            return true;
        }
        if(s==null||p==null) {
            return false;
        }
        //s!=null&&p!=null
        int[][] dp = new int[s.length()+1][p.length()+1];
        return isMatchHelper(s, p, 0, 0, dp);
    }

    private boolean isMatchHelper(String s, String p, int sIndex, int pIndex, int[][] dp) {
        if(dp[sIndex][pIndex]!=0) {
            return dp[sIndex][pIndex]==1 ? true : false;
        }

        if(sIndex==s.length()) {
            if(pIndex==p.length()) {
                dp[sIndex][pIndex]=1;
                return true;
            } else {
                for(int i=pIndex; i<p.length(); i++) {
                    if(p.charAt(i)!='*') {
                        dp[sIndex][pIndex]=-1;
                        return false;
                    }
                }
                dp[sIndex][pIndex]=1;
                return true;
            }
        }
        if(pIndex==p.length()) {
            dp[sIndex][pIndex]=-1;
            return false;
        }

        //sIndex<s.length()&&pIndex<p.length()
        char sc = s.charAt(sIndex);
        char pc = p.charAt(pIndex);
        if(sc==pc) {
            return isMatchHelper(s, p, sIndex+1, pIndex+1, dp);
        } else {
            if(pc=='?') {
                dp[sIndex][pIndex] = isMatchHelper(s, p, sIndex+1, pIndex+1, dp) == true ? 1 : -1;
                return dp[sIndex][pIndex] == 1 ? true : false;
            } else if(pc=='*') {
                dp[sIndex][pIndex] = (isMatchHelper(s, p, sIndex, pIndex+1, dp) || isMatchHelper(s, p, sIndex+1, pIndex+1, dp) || isMatchHelper(s, p, sIndex+1, pIndex, dp)) == true ? 1 : -1;
                return dp[sIndex][pIndex] == 1 ? true : false;
            } else {
                dp[sIndex][pIndex] = -1;
                return false;
            }
        }
    }
}