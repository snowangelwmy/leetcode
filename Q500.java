/**
 * Test cases:
 * 1: Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Q500 {

  public static final Map<Character, Integer> lookup = initialize();
  public static Map<Character, Integer> initialize() {
    Map<Character, Integer> lookup = new HashMap<> ();
    lookup.put('Q', 1);
    lookup.put('W', 1);
    lookup.put('E', 1);
    lookup.put('R', 1);
    lookup.put('T', 1);
    lookup.put('Y', 1);
    lookup.put('U', 1);
    lookup.put('I', 1);
    lookup.put('O', 1);
    lookup.put('P', 1);
    lookup.put('A', 2);
    lookup.put('S', 2);
    lookup.put('D', 2);
    lookup.put('F', 2);
    lookup.put('G', 2);
    lookup.put('H', 2);
    lookup.put('J', 2);
    lookup.put('K', 2);
    lookup.put('L', 2);
    lookup.put('Z', 3);
    lookup.put('X', 3);
    lookup.put('C', 3);
    lookup.put('V', 3);
    lookup.put('B', 3);
    lookup.put('N', 3);
    lookup.put('M', 3);
    return lookup;
  };

  public String[] findWords(String[] words) {
    if(words==null||words.length==0) {
      return new String[] {};
    }

    List<String> selectedWords = new ArrayList<>();
    for(int i=0; i<words.length; i++) {
      String word = words[i].toUpperCase();
      Set<Integer> indexes = new HashSet<>();
      for(int j=0; j<word.length(); j++) {
        indexes.add(lookup.get(word.charAt(j)));
      }
      if(indexes.size()==1) {
        selectedWords.add(words[i]);
      }
    }

    String[] result = new String[selectedWords.size()];
    result = selectedWords.toArray(result);
    return result;
  }

}
