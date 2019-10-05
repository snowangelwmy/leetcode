/**
 * Test cases:
 * 1: Input: s = "aaabb", k = 3
 * Output: 3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 2: Input: s = "ababbc", k = 2
 * Output: 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

import java.util.Arrays;

class Q395 {
  private static final int COUNT = 26;

  //Solution: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/170010/Java-O(n)-Solution-with-Detailed-Explanation-Sliding-Window
  public int longestSubstring(String s, int k) {
    if(s==null||s.length()==0) {
      return 0;
    }

    int max = 0;
    int[] counts = new int[COUNT];
    for(int i=1; i<=COUNT; i++) {
      int left=0;
      int right=0;
      int unique=0;
      int kOrMore=0;
      Arrays.fill(counts, 0);
      while(right<s.length()) {
        if(unique<=i) {
          int index=s.charAt(right)-'a';
          counts[index]++;
          if(counts[index]==1) {
            unique++;
          }
          if(counts[index]==k) {
            kOrMore++;
          }
          ++right;
        } else {//unique>i
          int index=s.charAt(left)-'a';
          counts[index]--;
          if(counts[index]==0) {
            unique--;
          }
          if(counts[index]==k-1) {
            kOrMore--;
          }
          left++;
        }
        if(unique==i && kOrMore==unique) {
          max = Math.max(max, right-left);
        }
      }
    }

    return max;
  }
}