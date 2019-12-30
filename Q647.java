/**
 * Test cases:
 * 1: Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 2: Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */

class Q647 {
  public int countSubstrings(String s) {
    if(s==null||s.length()==0) {
      return 0;
    }

    int N = s.length();
    int ans = 0;
    for(int center=0; center<2*N; center++) {
      int left = center / 2;
      int right = left + center % 2;
      while(left>=0 && right<N && s.charAt(left)==s.charAt(right)) {
        ans++;
        left--;
        right++;
      }
    }
    return ans;
  }
}