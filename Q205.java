/**
 * Test cases:
 * 1: Input: s = "egg", t = "add"
 * Output: true
 * 2: Input: s = "foo", t = "bar"
 * Output: false
 * 3: Input: s = "paper", t = "title"
 * Output: true
 * 4: Input: s = "aba", t = "baa"
 * Output: false
 */

import java.util.Map;
import java.util.HashMap;

class Q205 {
  public boolean isIsomorphic(String s, String t) {
    if(s==null&&t==null){
      return true;
    } else if(s==null||t==null||s.length()!=t.length()){
      return false;
    }

    //s!=null&&t!=null&&s.length()==t.length()
    Map<Character, Character> mapper = new HashMap<>();
    for(int i=0; i<s.length(); i++){
      Character sc = Character.valueOf(s.charAt(i));
      Character tc = Character.valueOf(t.charAt(i));
      if(mapper.containsKey(sc)) {
        if(mapper.get(sc)!=tc){
          return false;
        }
      } else {//!mapper.containsKey(sc)
        if(mapper.containsValue(tc)){
          return false;
        }
        //!mapper.containsValue(tc)
        mapper.put(sc, tc);
      }
    }
    return true;
  }
}