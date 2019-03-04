/**
 * Test cases:
 * 1: Input & Output:
 * buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class MagicDictionary {
    private Map<Integer, List<String>> lookup;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        lookup = new HashMap<Integer, List<String>>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict) {
            lookup.computeIfAbsent(word.length(), len -> new ArrayList<String>()).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!lookup.containsKey(word.length())) {return false;}
        for(String dictWord : lookup.get(word.length())) {
            int misMatch = 0;
            for(int i=0; i<word.length(); i++) {
                if(dictWord.charAt(i)!=word.charAt(i)) {
                    misMatch++;
                    if(misMatch>1) break;
                }
            }
            if(misMatch==1) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */