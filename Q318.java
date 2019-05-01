/**
 * Test cases:
 * 1: Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * 2: Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * 3: Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */

import java.util.Arrays;
import java.util.Comparator;

class Q318 {
    public int maxProduct(String[] words) {
        if(words==null|| words.length==0) {
            return 0;
        }

        //order word in words array in decreasing order of the length
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });

        int[] wordChars = new int[words.length]; //alphabet masks
        for(int i=0; i<words.length; i++) {
            if (words[i]!=null && words[i].length() > 0) {
                for(int j=0; j<words[i].length(); j++) {
                    wordChars[i] |= (1 << (words[i].charAt(j) - 'a'));
                }
            }
        }

        int maxValue = 0;
        for(int i=0; i<words.length; i++) {
            if (words[i].length() * words[i].length() <= maxValue) break;
            for(int j=i+1; j<words.length; j++) {
                if((wordChars[i] & wordChars[j]) == 0) {
                    maxValue = Math.max(maxValue, words[i].length() * words[j].length());
                }
            }
        }

        return maxValue;
    }
}