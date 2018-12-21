/**
 * Test cases:
 * 1: Input: "hello"
 * Output: "olleh"
 * 2: Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */

import java.lang.StringBuilder;

class Solution {
  public String reverseString(String s) {
    if(s==null||s.length()==0){
      return s;
    }
    StringBuilder builder = new StringBuilder();
    for(int i=s.length()-1; i>=0; i--){
      builder.append(s.charAt(i));
    }
    return builder.toString();
  }
}