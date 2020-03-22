/**
 * Test cases:
 * 1: Input: "hello"
 * Output: "holle"
 * 2: Input: "leetcode"
 * Output: "leotcede"
 * 3: Input: "aA"
 * Output: "Aa"
 * 4: Input: "Marge, let's \"went.\" I await news telegram."
 * Output: "Marge, let's \"went.\" i awaIt news telegram."
 */

import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;

class Q345 {
  private static final Set<Character> VOWEL_SET = new HashSet<>() {{
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

  //Two pointer solution
  public String reverseVowels(String s) {
    if(s==null||s.length()<2) {
      return s;
    }

    char[] array = s.toCharArray();
    int left = 0;
    int right = array.length-1;
    while(left<right) {
      char c = array[left];
      if(VOWEL_SET.contains(c)) {
        while(right>left) {
          if(!VOWEL_SET.contains(array[right])) {
            right--;
            continue;
          }

          swap(array, left, right);
          right--;
          break;
        }
      }
      left++;
    }

    return String.valueOf(array);
  }

  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }


  public String reverseVowels0(String s) {
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