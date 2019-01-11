/**
 * Test cases:
 * 1: Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 2: Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 3: Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 4: Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */

import java.util.Map;
import java.util.HashMap;

class Q290 {
  public boolean wordPattern(String pattern, String str) {
    if(pattern==null||str==null||pattern.length()!=str.split(" ").length) {
      return false;
    }
    String[] words = str.split(" ");
    Map<Character, String> wordLookup = new HashMap<>();
    Map<String, Character> patternLookup = new HashMap<>();
    for(int i=0; i<pattern.length(); i++){
      Character c = Character.valueOf(pattern.charAt(i));
      if(wordLookup.containsKey(c)){
        if(!wordLookup.get(c).equals(words[i])){
          return false;
        }
      } else if (patternLookup.containsKey(words[i])){
        if(!patternLookup.get(words[i]).equals(c)) {
          return false;
        }
      }
      else {
        wordLookup.put(c, words[i]);
        patternLookup.put(words[i], c);
      }
    }

    return true;
  }
}