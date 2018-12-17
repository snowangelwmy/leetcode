/**
 * Test cases:
 * 1: Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

class Solution {
  public boolean isHappy(int n) {
    Map<Integer,Boolean> lookup = new HashMap<>();
    int sum = calculateSum(n);
    while(!lookup.containsKey(sum)){
      if(sum==1){
        return true;
      }
      lookup.put(sum, true);
      sum = calculateSum(sum);
    }
    return false;
  }

  private int calculateSum(int n){
    int sum = 0;
    String s = String.valueOf(n);
    for(int i=0; i<s.length(); i++){
      sum += Math.pow(Character.getNumericValue(s.charAt(i)),2);
    }
    return sum;
  }
}