/**
 * Test cases:
 * 1: Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 2: Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * 3: Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * 4: Input: 1
 * Output: true
 */

class Q263 {
  public boolean isUgly(int num) {
    if(num<=0){
      return false;
    }
    //num>1
    while(num%2==0){
      num /= 2;
    }
    while(num%3==0){
      num /= 3;
    }
    while(num%5==0){
      num /= 5;
    }
    if(num==1){
      return true;
    } else {
      return false;
    }
  }
}