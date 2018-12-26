/**
 * Test cases:
 * 1: Input & Output:
 * s = "leetcode"
 * return 0.
 * 2: Input & Output:
 * s = "loveleetcode",
 * return 2.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
  public int firstUniqChar(String s) {
    if(s==null||s.length()==0){
      return -1;
    }
    Map<Character, List<Integer>> lookup = new HashMap<>();
    for(int i=0; i<s.length(); i++){
      Character c = Character.valueOf(s.charAt(i));
      if(!lookup.containsKey(c)){
        lookup.put(c, new ArrayList<Integer>());
      }

      List<Integer> indexes = lookup.get(c);
      indexes.add(i);
    }
    int firstNonRepeatingCharacter = -1;
    for(Map.Entry<Character, List<Integer>> entry: lookup.entrySet()) {
      List<Integer> indexes = entry.getValue();
      if(indexes.size()==1){
        if(firstNonRepeatingCharacter==-1||firstNonRepeatingCharacter>indexes.get(0)) {
          firstNonRepeatingCharacter = indexes.get(0);
        }
      }
    }

    return firstNonRepeatingCharacter;
  }
}