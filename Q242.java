/**
 * Test cases:
 * 1: Input: s = "anagram", t = "nagaram"
 * Output: true
 * 2: Input: s = "rat", t = "car"
 * Output: false
 */

import java.util.Map;
import java.util.HashMap;

class Q242 {
  public boolean isAnagram(String s, String t) {
    if(s==null&&t==null){
      return true;
    } else if(s==null||t==null||s.length()!=t.length()){
      return false;
    }

    //s!=null&&t!=null
    Map<Character, Integer> lookup = new HashMap<>();
    for(int i=0; i<s.length(); i++){
      Character c = Character.valueOf(s.charAt(i));
      if(!lookup.containsKey(c)){
        lookup.put(c,0);
      }
      lookup.put(c, lookup.get(c)+1);
    }

    for(int i=0; i<t.length(); i++){
      Character c = Character.valueOf(t.charAt(i));
      if(!lookup.containsKey(c)) {
        return false;
      }
      int count = lookup.get(c)-1;
      if(count == 0){
        lookup.remove(c);
      } else {
        lookup.put(c, count);
      }
    }
    return true;
  }
}