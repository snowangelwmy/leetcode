/**
 * Test cases:
 * 1: Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 */

import java.util.Map;
import java.util.HashMap;

class Q792 {

    private static final int NUM = 26;

    class TrieNode {
        TrieNode[] children;
        Boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[NUM];
            isEndOfWord = false;
        }
    }

    public int numMatchingSubseq(String S, String[] words) {
        if(S==null||S.length()==0) {
            return 0;
        }

        TrieNode root = buildTree(S);
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
        }

        int totalCount = 0;
        for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if(isSub(root, word)) {
                totalCount += count;
            }
        }
        return totalCount;
    }

    private TrieNode buildTree(String s) {
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i)-'a';
            if(cur.children[index]==null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEndOfWord = true;
        return root;
    }

    private boolean isSub(TrieNode root, String word) {
        TrieNode cur = root;
        int i=0;
        while(i<word.length()) {
            int index = word.charAt(i)-'a';
            if(cur.children[index]==null) {
                if(cur.isEndOfWord) {
                    return false;
                }
                for(int j=0; j<NUM; j++) {
                    if(cur.children[j]!=null) {
                        cur = cur.children[j];
                        break;
                    }
                }
            } else {
                cur = cur.children[index];
                if(cur.isEndOfWord) {
                    return i==word.length()-1;
                }
                i++;
            }
        }

        return true;
    }
}