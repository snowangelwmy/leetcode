/**
 * Test cases:
 * 1: Input: "hello"
 * Output: "holle"
 * 2: Input: "leetcode"
 * Output: "leotcede"
 * 3: Input: "aA"
 * Output: "Aa"
 */

import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;

class Solution {
  private static final Set<Character> VOWEL_SET = new HashSet<Character>() {{
    add('a');
    add('e');
    add('i');
    add('o');
    add('u');
    add('A');
    add('E');
    add('I');
    add('O');
    add('U');
  }};

  public String reverseVowels(String s) {
    if(s==null||s.length()==0){
      return s;
    }
    Stack<Character> vowels = new Stack<>();
    boolean[] isVowel = new boolean[s.length()];
    for(int i=0; i<s.length(); i++){
      Character c = Character.valueOf(s.charAt(i));
      if(VOWEL_SET.contains(c)) {
        isVowel[i] = true;
        vowels.push(c);
      } else {
        isVowel[i] = false;
      }
    }
    StringBuilder builder = new StringBuilder();
    for(int i=0; i<s.length(); i++){
      Character c;
      if(isVowel[i]){
        c = vowels.pop();
      } else {
        c = Character.valueOf(s.charAt(i));
      }
      builder.append(c);
    }
    return builder.toString();
  }
}