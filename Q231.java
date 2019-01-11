/**
 * Test cases:
 * 1: Input: 1
 * Output: true
 * Explanation: 20 = 1
 * 2: Input: 16
 * Output: true
 * Explanation: 24 = 16
 * 3: Input: 218
 * Output: false
 */

class Q231 {
  public boolean isPowerOfTwo(int n) {
    return n>0 && bitCount(n)==1;
  }

  private int bitCount(int n){
    int count = 0;
    int mask = 1;
    for(int i=0; i<32; i++){
      if((n&mask)!=0){
        count++;
      }
      mask <<= 1;
    }
    return count;
  }
}