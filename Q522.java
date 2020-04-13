/**
 * Test cases:
 * 1: Input: "aba", "cdc", "eae"
 * Output: 3
 */

class Q522 {
    //https://leetcode.com/problems/longest-uncommon-subsequence-ii/discuss/144926/JAVA-13-lines-5ms-beats-100-with-explaination
    public int findLUSlength(String[] strs) {
        int res = -1;
        if(strs==null||strs.length==0) {
            return res;
        }

        for(int i=0; i<strs.length; i++) {
            if(strs[i].length()<res) continue;
            int j = 0;
            while(j<strs.length) {
                if(j!=i&&isSubsequence(strs[i], strs[j])) {
                    break;
                }
                j++;
            }
            if(j==strs.length) res = Math.max(res, strs[i].length());
        }

        return res;
    }

    private boolean isSubsequence(String a, String b) {
        int i=0;
        int j=0;
        while(i<a.length()&&j<b.length()) {
            if(a.charAt(i)==b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i==a.length();
    }
}