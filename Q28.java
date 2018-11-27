/**
 * Test cases:
 * 1: Input: haystack = "hello", needle = "ll", Output: 2
 * 2: Input: haystack = "aaaaa", needle = "bba", Output: -1
 */

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null){
            return -1;
        }

        if(needle.length()==0){
            return 0;
        }

        for(int i=0; i<haystack.length(); i++){
            if(doesMatch(haystack, needle, i)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean doesMatch(String haystack, String needle, int index) {
        for(int i=0; i<needle.length(); i++) {
            if(index+i>=haystack.length() || haystack.charAt(index+i)!= needle.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}