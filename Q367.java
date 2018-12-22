/**
 * Test cases:
 * 1: Input: 16
 * Output: true
 * 2: Input: 14
 * Output: false
 */

class Solution {
  public boolean isPerfectSquare(int num) {
    if(num<0) {
      return false;
    }
    int root = 0;
    int mask = 1 << 15; //2^16
    while(mask>0) {
      root |= mask;
      if(root > num/root) {
        root ^= mask;
      }
      mask >>= 1;
    }

    return root*root == num;
  }
}