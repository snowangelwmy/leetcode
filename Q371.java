/**
 * Test cases:
 * 1: Input: a = 1, b = 2
 * Output: 3
 * 2: Input: a = -2, b = 3
 * Output: 1
 */

class Solution {
  public int getSum(int a, int b) {
    if(a==0) return b;
    if(b==0) return a;
    while(b!=0){
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }

    return a;
  }
}