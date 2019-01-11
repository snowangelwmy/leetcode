/**
 * Test cases:
 * 1: Input:
 * s = "abcd"
 * t = "abcde"
 * Output:
 * e
 * Explanation:
 * 'e' is the letter that was added.
 */

import java.util.Map;
import java.util.HashMap;

class Q389 {
  public char findTheDifference(String s, String t) {
    Map<Character, Integer> lookup = new HashMap<>();
    for(int i=0; s!=null && i<s.length(); i++){
      Character c = Character.valueOf(s.charAt(i));
      if(!lookup.containsKey(c)) {
        lookup.put(c, 0);
      }
      lookup.put(c, lookup.get(c)+1);
    }
    Character letter = null;
    for(int i=0; t!=null && i<t.length(); i++){
      Character c = Character.valueOf(t.charAt(i));
      if(lookup.containsKey(c)) {
        int count = lookup.get(c)-1;
        if(count==0) {
          lookup.remove(c);
        } else {
          lookup.put(c, count);
        }
      } else {
        letter = c;
      }
    }

    if(lookup.size()>0 && letter==null) {
      for(Character c: lookup.keySet()) {
        letter = c;
      }
    }

    return letter==null?'-':letter.charValue();
  }
}