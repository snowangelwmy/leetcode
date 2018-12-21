/**
 * Test cases:
 * 1: Input: 16
 * Output: true
 * 2: Input: 5
 * Output: false
 */

class Solution {
  public boolean isPowerOfFour(int num) {
    return num>0 && ((num&(num-1))==0) && ((num-1)%3==0);
  }
}