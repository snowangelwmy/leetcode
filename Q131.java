/**
 * Test cases:
 * 1: Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 2: Input: "cdd"
 * Output:
 * [
 *   ["c","d", "d"],
 *   ["c","dd"]
 * ]
 * 3: Input: "cbbbcc"
 * Output:
 * [
 *   ["c", "b", "b", "b", "c", "c"],
 *   ["c", "b", "b", "b", "cc"],
 *   ["c", "b", "bb", "c", "c"],
 *   ["c", "b", "bb", "cc"],
 *   ["c", "bb", "b", "c", "c"],
 *   ["c", "bb", "b", "cc"],
 *   ["c", "bbb", "c", "c"],
 *   ["c", "bbb", "cc"],
 *   ["cbbbc", "c"]
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q131 {
    //https://leetcode.com/problems/palindrome-partitioning/discuss/446103/Easy-Java-solution-using-recursion-beats-95
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s==null||s.length()==0) {
            return result;
        }

        partitionHelper(s, 0, result, new ArrayList<String>());

        return result;
    }

    private void partitionHelper(String s, int index, List<List<String>> result, List<String> substrings) {
        if(index==s.length()) {
            result.add(new ArrayList<String>(substrings));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                substrings.add(s.substring(index, i+1));
                partitionHelper(s, i+1, result, substrings);
                substrings.remove(substrings.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}