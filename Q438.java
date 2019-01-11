/**
 * Test cases:
 * 1: Input: s: "cbaebabacd" p: "abc"
 * Output: [0, 6]
 * Explanation:
 *  The substring with start index = 0 is "cba", which is an anagram of "abc".
 *  The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 2: Input: s: "abab" p: "ab"
 * Output: [0, 1, 2]
 * Explanation:
 *  The substring with start index = 0 is "ab", which is an anagram of "ab".
 *  The substring with start index = 1 is "ba", which is an anagram of "ab".
 *  The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Q438 {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> indexes = new ArrayList<>();
    if(s==null||p==null||s.length()==0||p.length()==0||s.length()<p.length()){
      return indexes;
    }

    Map<Character, Integer> lookup = new HashMap<>();
    for(int i=0; i<p.length(); i++){
      Character c = Character.valueOf(p.charAt(i));
      lookup.put(c, lookup.getOrDefault(c, 0)+1);
    }

    int notMatchedChars = lookup.size();

    int begin = 0;
    int end = 0;
    while(end<s.length()){
      Character cEnd = Character.valueOf(s.charAt(end));
      if(lookup.containsKey(cEnd)) {
        lookup.put(cEnd, lookup.get(cEnd)-1);
        if(lookup.get(cEnd)==0) {
          notMatchedChars--;
        }
      }
      end++;

      while(notMatchedChars==0){
        if(end-begin==p.length()){
          indexes.add(begin);
        }

        Character cBegin = Character.valueOf(s.charAt(begin));
        if(lookup.containsKey(cBegin)) {
          lookup.put(cBegin, lookup.get(cBegin)+1);
          if(lookup.get(cBegin)==1){
            notMatchedChars++;
          }
        }
        begin++;
      }
    }

    return indexes;
  }
}