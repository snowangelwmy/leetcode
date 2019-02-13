/**
 * Test cases:
 * 1: Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * 2: Input: s = "abpcplea", d = ["a","b","c"]
 * Output: "a"
 */

import java.util.List;

class Q524 {
    public String findLongestWord(String s, List<String> d) {
        String maxStr = "";
        for(String ds : d) {
            if(isSubsequence(s, ds)) {
                if(ds.length()>maxStr.length() || (ds.length()==maxStr.length() && ds.compareTo(maxStr) < 0)) {
                    maxStr = ds;
                }
            }
        }
        return maxStr;
    }

    private boolean isSubsequence(String s, String word) {
        int i = 0;
        for(int j=0; j<s.length() && i<word.length(); j++) {
            if(s.charAt(j)==word.charAt(i)) {
                i++;
            }
        }
        return i==word.length();
    }
}