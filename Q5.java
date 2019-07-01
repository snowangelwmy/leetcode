/**
 * Test cases:
 * 1: Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 2: Input: "cbbd"
 * Output: "bb"
 */

class Q5 {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) {
            return "";
        }
        int len = s.length();
        int[][] memo = new int[len][len];
        String longestPalindrome = "";
        for(int i=0; i<len; i++) {
            for(int j=len-1; j>=i; j--) {
                if(isPalindrome(s, i, j, memo) && (j-i+1) > longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j+1);
                }
            }
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(String s, int start, int end, int[][] memo) {
        if(memo[start][end]!=0){
            return memo[start][end]==1 ? true : false;
        }
        if(start==end) {
            memo[start][end] = 1;
            return true;
        }
        if(start+1==end) {
            if(s.charAt(start)==s.charAt(end)) {
                memo[start][end] = 1;
                return true;
            } else {
                memo[start][end] = -1;
                return false;
            }
        }
        if(s.charAt(start)==s.charAt(end) && isPalindrome(s, start+1, end-1, memo)) {
            memo[start][end] = 1;
            return true;
        } else {
            memo[start][end] = -1;
            return false;
        }
    }
}