/**
 * Test cases:
 * 1: Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * 2: Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * 3: Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

class Q140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s==null||s.length()==0||wordDict==null||wordDict.size()==0) {
            return result;
        }

        boolean[] hasSentence = new boolean[s.length()+1];
        List<Integer>[] preIndexes = new List[s.length()+1];
        for(int i=0; i<preIndexes.length; i++) {
            preIndexes[i] = new ArrayList<Integer>();
        }
        hasSentence[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(hasSentence[j] && wordDict.contains(s.substring(j, i))) {
                    hasSentence[i] = true;
                    preIndexes[i].add(j);
                }
            }
        }
        if(hasSentence[s.length()]) {
            generateSentences(s, new StringBuilder(""), preIndexes, s.length(), result);
        }
        return result;
    }

    private void generateSentences(String s, StringBuilder prefix, List<Integer>[] preIndexes, int index, List<String> result) {
        if(index==0) {
            result.add(prefix.toString().trim());
            return;
        }
        for(int preIndex : preIndexes[index]) {
            prefix.insert(0, " ");
            prefix.insert(0, s.substring(preIndex, index));
            generateSentences(s, prefix, preIndexes, preIndex, result);
            prefix.delete(0, index-preIndex+1);
        }
    }
}