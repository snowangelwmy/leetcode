/**
 * Test cases:
 * 1: Input: 16
 * Output: true
 * 2: Input: 5
 * Output: false
 */

class Q342 {
  //https://leetcode.com/problems/power-of-four/discuss/80617/One-line-in-JAVA-without-loopsrecursion-which-is-extensible.
  public boolean isPowerOfFour(int num) {
    //num>0 && ((num&(num-1))==0) are for power of 2.
    //x^n - 1 = (x - 1)*(x^(n-1)+...+x+1); so x^n - 1 has a factor x - 1. here x = 4.
    return num>0 && ((num&(num-1))==0) && ((num-1)%3==0);
  }
}