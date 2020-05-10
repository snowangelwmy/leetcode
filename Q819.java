/**
 * Test cases:
 * 1: Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Q819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph==null||paragraph.length()==0) {
            return null;
        }

        Set<String> bannedWords = new HashSet<>();
        for(String bannedWord : banned) {
            bannedWords.add(bannedWord.toLowerCase());
        }

        String newParagraph = paragraph.toLowerCase().replaceAll("[^a-z\\s]", " ").replaceAll("\\s{2,}", " ");
        String[] words = newParagraph.split(" ");

        String frequentWord = null;
        int frequency = 0;
        Map<String, Integer> lookup = new HashMap<>();
        for(String curWord: words) {
            if(!lookup.containsKey(curWord)) {
                lookup.put(curWord, 0);
            }
            int curFrequency = lookup.get(curWord)+1;
            lookup.put(curWord, curFrequency);
            if(!bannedWords.contains(curWord)&&(frequentWord==null||frequency<curFrequency)) {
                frequentWord = curWord;
                frequency = curFrequency;
            }
        }

        return frequentWord;
    }
}