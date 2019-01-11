/**
 * Test cases:
 * 1: Input: 15
 * Output:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q412 {
  public List<String> fizzBuzz(int n) {
    List<String> nums = new ArrayList<>();
    if(n<=0){
      return nums;
    }
    //n>=1
    for(int i=1; i<=n; i++){
      String output = "";
      if(i%3!=0&&i%5!=0){
        output += String.valueOf(i);
      } else {
        if(i%3==0){
          output += "Fizz";
        }
        if(i%5==0){
          output += "Buzz";
        }
      }
      nums.add(output);
    }

    return nums;
  }
}