/**
 * Test cases:
 * 1: Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * 2: Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */

class Solution {
  public int findComplement(int num) {
    int result = 0;
    int mask = 1;
    for(int i=0; i<31 && mask <= num; i++) {
      result = num&mask^mask|result;
      mask <<= 1;
    }
    return result;
  }
}