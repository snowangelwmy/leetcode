/**
 * Test cases:
 * 1: Input & Output:
 * canConstruct("a", "b") -> false
 * 2: Input & Output:
 * canConstruct("aa", "ab") -> false
 * 3: Input & Output:
 * canConstruct("aa", "aab") -> true
 * 4: Input & Output:
 * canConstruct("", "") -> true
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    if(ransomNote==null){
      return true;
    }
    if(magazine==null){
      return false;
    }
    Map<Character, Integer> lookup = new HashMap<>();
    for(int i=0; i<ransomNote.length(); i++){
      Character c = Character.valueOf(ransomNote.charAt(i));
      if(!lookup.containsKey(c)) {
        lookup.put(c, 0);
      }
      lookup.put(c, lookup.get(c)+1);
    }
    for(int i=0; i<magazine.length(); i++){
      Character c = Character.valueOf(magazine.charAt(i));
      if(lookup.containsKey(c)) {
        int count = lookup.get(c)-1;
        if(count==0){
          lookup.remove(c);
          if(lookup.size()==0){
            break;
          }
        } else {
          lookup.put(c, count);
        }
      }
    }

    if(lookup.size()==0){
      return true;
    } else {
      return false;
    }
  }
}