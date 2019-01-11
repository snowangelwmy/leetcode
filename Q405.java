/**
 * Test cases:
 * 1: Input: 26
 * Output: "1a"
 * 2: Input: -1
 * Output: "ffffffff"
 */

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

class Q405 {
  private static final Map<Integer, Character> lookup = initializeMap();
  private static Map<Integer, Character> initializeMap() {
    Map<Integer, Character> lookup = new HashMap<>();
    lookup.put(0, '0');
    lookup.put(1, '1');
    lookup.put(2, '2');
    lookup.put(3, '3');
    lookup.put(4, '4');
    lookup.put(5, '5');
    lookup.put(6, '6');
    lookup.put(7, '7');
    lookup.put(8, '8');
    lookup.put(9, '9');
    lookup.put(10, 'a');
    lookup.put(11, 'b');
    lookup.put(12, 'c');
    lookup.put(13, 'd');
    lookup.put(14, 'e');
    lookup.put(15, 'f');
    return lookup;
  }

  public String toHex(int num) {
    StringBuilder builder = new StringBuilder();
    if(num==0) {
      builder.append(0);
    }
    else if(num>0){
      while(num>0){
        builder.insert(0, lookup.get(num%16));
        num /= 16;
      }
    } else { //num<0
      int mask = 15;
      for(int i=0; i<8; i++){
        builder.insert(0, lookup.get(num&mask));
        num >>= 4;
      }
    }
    return builder.toString();
  }
}