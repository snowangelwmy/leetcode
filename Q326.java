/**
 * Test cases:
 * 1: Input: 27
 * Output: true
 * 2: Input: 0
 * Output: false
 * 3: Input: 9
 * Output: true
 * 4: Input: 45
 * Output: false
 */

class Solution {
  //Integer Limitations
  public boolean isPowerOfThree(int n) {
    if(n<=0) {
      return false;
    }
    int maxPower = getMaxPowerOfThree();
    return maxPower%n == 0;
  }

  private int getMaxPowerOfThree(){
    int maxInteger = Integer.MAX_VALUE;
    return (int)Math.pow(3, (int)(Math.log10(maxInteger)/Math.log10(3)));
  }

  //subject to precision errors
  public boolean isPowerOfThree2(int n) {
    if(n<=0) {
      return false;
    }
    return (Math.log10(n)/Math.log10(3))%1==0;
  }
  //using a loop / recursion
  public boolean isPowerOfThree1(int n) {
    if(n<=0) {
      return false;
    }
    while(n%3==0){
      n /= 3;
    }
    return n==1;
  }
}