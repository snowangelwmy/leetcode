/**
 * Test cases:
 * 1: Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * 2: Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */

class Q474 {
  //https://leetcode.com/problems/ones-and-zeroes/discuss/177639/Java-DP-Solution-2-Solutions-with-Explanation
  public int findMaxForm(String[] strs, int m, int n) {
    if(strs==null||strs.length==0) {
      return 0;
    }

    int[] zeros = new int[strs.length];
    int[] ones = new int[strs.length];
    for(int i=0; i<strs.length; i++) {
      String str = strs[i];
      for(int j=0; j<str.length(); j++) {
        char c = str.charAt(j);
        if(c=='0') {
          zeros[i]++;
        } else { //c=='1'
          ones[i]++;
        }
      }
    }

    //the maximum number of strings that you can form with given mm 0s, nn 1s and i strings.
    int[][][] numCache = new int[m+1][n+1][strs.length+1];
    for(int i=0; i<strs.length; i++) {
      for(int mm=0; mm<=m; mm++) {
        for(int nn=0; nn<=n; nn++) {
          if(mm>=zeros[i] && nn>=ones[i]) {
            numCache[mm][nn][i+1] = Math.max(numCache[mm][nn][i], numCache[mm-zeros[i]][nn-ones[i]][i]+1);
          } else {
            numCache[mm][nn][i+1] = numCache[mm][nn][i];
          }
        }
      }
    }
    return numCache[m][n][strs.length];
  }
}