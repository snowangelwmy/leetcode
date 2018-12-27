/**
 * Test cases:
 * 1: Input: 3
 * Output: 3
 * 2: Input: 11
 * Output: 0
 * 3: Input: 1000000000
 * Output: 1
 */

import java.lang.Math;

class Solution {
  public int findNthDigit(int n) {
    if(n<=0){
      return -1;
    }
    //n>0
    int digits = 1;
    long count = 9; //to avoid integer overflow
    while(n-digits*count>0){
      n -= digits*count;
      digits++;
      count *= 10;
    }
    int baseNumber = (int)Math.pow(10, digits-1);
    int number = (n-1)/digits + baseNumber;
    int mod = (n-1)%digits;
    return String.valueOf(number).charAt(mod) - '0';
  }
}