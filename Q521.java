/**
 * Test cases:
 * 1: Input: "aba", "cdc"
 * Output: 3
 * 2: Input: "aaa", "aaa"
 * Output: -1
 * 3: Input: "aweffwaf", "aweffwaf"
 * Output: -1
 */

class Q521 {
    public int findLUSlength(String a, String b) {
        if(a==null&&b==null) {
            return -1;
        }
        if(a==null) {
            return b.length();
        }
        if(b==null) {
            return a.length();
        }
        if(a.length()==b.length()) {
            if(a.equals(b)) {
                return -1;
            } else {
                return a.length();
            }
        } else {
            return Math.max(a.length(), b.length());
        }
    }
}