/**
 * Test cases:
 * 1: Input: "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

import java.util.Map;
import java.util.HashMap;

class Q409 {
  public int longestPalindrome(String s) {
    int length = 0;
    if(s==null||s.length()==0){
      return length;
    }

    Map<Character, Integer> lookup = new HashMap<>();
    for(int i=0; i<s.length(); i++){
      Character c = Character.valueOf(s.charAt(i));
      if(!lookup.containsKey(c)){
        lookup.put(c, 0);
      }
      lookup.put(c, lookup.get(c)+1);
    }

    boolean hasOdd = false;
    for(Map.Entry<Character, Integer> entry: lookup.entrySet()) {
      int count = entry.getValue();
      if(count%2==0){
        length += count;
      } else {//count%2==1
        if(count/2>0){
          length += (count/2)*2;
        }
        hasOdd = true;
      }
    }
    if(hasOdd) {
      length++;
    }

    return length;
  }
}