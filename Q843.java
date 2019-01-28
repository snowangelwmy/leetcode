/**
 * Test cases:
 * 1: Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * Explanation:
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 *
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

import java.util.Map;
import java.util.HashMap;
import javafx.util.Pair;
import java.util.List;
import java.util.ArrayList;

class Q843 {
    public void findSecretWord(String[] wordlist, Master master) {
        for(int i=0; i<10; i++) {
            Map<String, Integer> lookup = new HashMap<>();
            for(String word1 : wordlist) {
                int zeroCount = 0;
                for(String word2 : wordlist) {
                    if(match(word1, word2)==0) {
                        zeroCount++;
                    }
                }
                lookup.put(word1, zeroCount);
            }
            Pair<String, Integer> minimum = new Pair<>("", Integer.MAX_VALUE);
            for(Map.Entry<String, Integer> entry : lookup.entrySet()) {
                if(entry.getValue()<minimum.getValue()) {
                    minimum = new Pair<>(entry.getKey(), entry.getValue());
                }
            }
            int matchCount = master.guess(minimum.getKey());
            List<String> newWordlist = new ArrayList<String>();
            for(String word : wordlist) {
                if(match(minimum.getKey(), word)==matchCount) {
                    newWordlist.add(word);
                }
            }
            wordlist = newWordlist.toArray(new String[0]);
        }
    }

    private int match(String word1, String word2) {
        int match = 0;
        for(int i=0; i<6; i++) {
            if(word1.charAt(i)==word2.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}