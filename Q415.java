/**
 * Test cases:
 * 1: Input: "234", "478"
 * Output: "712"
 * 2: Input: "23", "980"
 * Output: "1003"
 * 3: Input: "348", "58"
 * Output: "406"
 */

import java.lang.StringBuilder;

class Q415 {
  public String addStrings(String num1, String num2) {
    if(num1==null||num1.length()==0){
      return num2;
    }
    if(num2==null||num2.length()==0){
      return num1;
    }
    StringBuilder builder = new StringBuilder();
    int carry = 0;
    int i = num1.length()-1;
    int j = num2.length()-1;
    while(i>=0&&j>=0){
      int value1 = Character.getNumericValue(num1.charAt(i));
      int value2 = Character.getNumericValue(num2.charAt(j));
      int value = value1 + value2 + carry;
      //System.out.println(value1+":"+value2+":"+value);
      if(value>9){
        carry = 1;
        value -= 10;
      } else {
        carry = 0;
      }
      builder.insert(0, value);
      i--;
      j--;
    }
    while(i>=0){
      int value1 = Character.getNumericValue(num1.charAt(i));
      int value = value1 + carry;
      if(value>9){
        carry = 1;
        value -= 10;
      } else {
        carry = 0;
      }
      builder.insert(0, value);
      i--;
    }
    while(j>=0){
      int value2 = Character.getNumericValue(num2.charAt(j));
      int value = value2 + carry;
      if(value>9){
        carry = 1;
        value -= 10;
      } else {
        carry = 0;
      }
      builder.insert(0, value);
      j--;
    }
    if(carry==1){
      builder.insert(0, 1);
    }

    return builder.toString();
  }
}