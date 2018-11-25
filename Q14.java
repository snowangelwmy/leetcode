/**
 * Test cases:
 * 1: Input: ["flower","flow","flight"], Output: "fl"
 * 2: Input: ["dog","racecar","car"], Output: ""
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length <=0) {
            return "";
        }

        String commonPrefix = strs[0];
        for(int i=1; i<strs.length; i++){
            String str1 = commonPrefix;
            String str2 = strs[i];
            int j = -1;
            for(; j+1<str1.length() && j+1<str2.length(); j++){
                if(str1.charAt(j+1) != str2.charAt(j+1)) {
                    break;
                }
            }

            if (j==-1) {
                return "";
            }
            commonPrefix = str1.substring(0, j+1);
        }

        return commonPrefix;
    }
}