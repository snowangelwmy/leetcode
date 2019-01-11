/**
 * Test cases:
 * 1: Input: 1, Output: 9
 * 2: Input: 2, Output: 987
 * 3: Input: 3, Output: 123
 * 4: Input: 4, Output: 597
 * 5: Input: 5, Output: 677
 * 6: Input: 6, Output: 1218
 * 7: Input: 7, Output: 877
 * 8: Input: 8, Output: 475
 */

import java.lang.Math;
import java.lang.StringBuilder;

public class Q479 {
    public int largestPalindrome(int n) {
      if(n<=0) {
        return -1;
      }
      if(n==1) {
        return 9;
      }
      int upperBound = (int)Math.pow(10, n) - 1; //include
      int lowerBound = (int)Math.pow(10, n-1); //exclude
      long maxNumber = (long)upperBound * (long)upperBound;//integer overflow

      long palindrome;

      int firstHalf = (int)(maxNumber/(long)Math.pow(10, n));
      while(firstHalf>=lowerBound) {
        palindrome = createPalindrome(firstHalf);
        for(int i=upperBound; i>=lowerBound; i--) {
          int j = (int)(palindrome/i);
          //palindrome is too big
          if(j>upperBound || (long)i*(long)i<palindrome) {//integer overflow
            break;
          }
          //i is too big
          if(j<lowerBound) {
            continue;
          }

          if(palindrome%i==0) {
            return (int)(palindrome%1337);
          }
        }
        firstHalf--;
      }

      return -1;
    }

    private long createPalindrome(int firstHalf) {
      StringBuilder builder = new StringBuilder();
      builder.append(firstHalf);
      builder.append(new StringBuilder().append(firstHalf).reverse());
      return Long.parseLong(builder.toString());
    }
}
