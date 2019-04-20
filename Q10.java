/**
 * Test cases:
 * 1: Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 2: Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * 3: Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 4: Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * 5: Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */

class Q10 {
    public boolean isMatch(String s, String p) {
        if ( s == null && p == null ) {
            return true;
        } else if ( s == null || p == null ) {
            return false;
        }

        int[][] lookup = new int[s.length()+1][p.length()+1];
        return dp(0, 0, s, p, lookup);
    }

    private boolean dp(int i, int j, String s, String p, int[][] lookup) {
        if( lookup[i][j] != 0 ) {
            return ( lookup[i][j] == 1 ) ? true : false;
        }
        boolean result = false;
        if( j == p.length() ) {
            result = ( i == s.length() );
        } else {//j < p.length()
            boolean firstMatch = ( i < s.length() ) &&
                    ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if ( ( j + 1 ) < p.length() && p.charAt( j + 1) == '*' ) {
                result = ( firstMatch && dp(i+1, j, s, p, lookup) )
                        || dp(i, j+2, s, p, lookup);
            } else {
                result = firstMatch && dp(i+1, j+1, s, p, lookup);
            }
        }
        lookup[i][j] = result ? 1 : -1;
        return result;
    }
}