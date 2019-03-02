/**
 * Test cases:
 * 1: Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 2: Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * 3: Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

import java.util.List;

class Q139 {
    //Dynamic Programming
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0||wordDict==null||wordDict.size()==0) {
            return false;
        }
        boolean[] lookup = new boolean[s.length()+1];
        lookup[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(lookup[j] && wordDict.contains(s.substring(j, i))) {
                    lookup[i] = true;
                    break;
                }
            }
        }

        return lookup[s.length()];
    }
}