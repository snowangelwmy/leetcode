/**
 * Test cases:
 * 1: Input: 00000010100101000001111010011100 -> unsigned integer 43261596
 * Output: 00111001011110000010100101000000 -> unsigned integer 964176192
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * 2: Input: 11111111111111111111111111111101 -> unsigned integer 4294967293 or signed integer -3
 * Output: 10111111111111111111111111111111 -> unsigned integer 3221225471 or signed integer -1073741825
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 */

public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    int mask = 1;
    for(int i=0; i<32; i++){
      if((n&mask)!=0){
        result |= 1<<(31-i);
      }
      mask <<= 1;
    }
    return result;
  }
}