/**
 * Test cases:
 * 1: Input: "hello"
 * Output: "olleh"
 * 2: Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */

import java.lang.StringBuilder;

class Q344 {

  public void reverseString(char[] s) {
    if(s==null||s.length<2) {
      return;
    }

    for(int i=0; i<s.length/2; i++) {
      swap(s, i, s.length-1-i);
    }
  }

  private void swap(char[] s, int i, int j) {
    char c = s[i];
    s[i] = s[j];
    s[j] = c;
  }

  public String reverseString0(String s) {
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