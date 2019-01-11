/**
 * Test cases:
 * 1: Input: 00000000000000000000000000001011 -> 11
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * 2: Input: 00000000000000000000000010000000 -> 128
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * 3: Input: 11111111111111111111111111111101 -> -3
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */

public class Q191 {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for(int i=0; i<32; i++){
      if((n&mask)!=0){
        bits++;
      }
      mask <<= 1;
    }
    return bits;
  }
}