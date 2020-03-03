/**
 * Test cases:
 * 1: Input: dividend = 10, divisor = 3
 * Output: 3
 * 2: Input: dividend = 7, divisor = -3
 * Output: -2
 * 3: Input: dividend = 2147483647, divisor = -1
 * Output: -2147483647
 * 4: Input: dividend = -2147483648, divisor = -1
 * Output: 2147483647
 * 5: Input: dividend = -2147483648, divisor = -2147483648
 * Output: 1
 */

class Q29 {
    //https://leetcode.com/problems/divide-two-integers/discuss/480305/EXPLAINED-JAVA-1ms-oror-Without-Long-oror-100
    public int divide(int dividend, int divisor) {
        if(dividend==0) {
            return 0;
        }
        if(divisor==1) {
            return dividend;
        }

        long result = 0;
        long newDividend = dividend;
        newDividend = newDividend<0 ? -newDividend : newDividend;
        long newDivisor = divisor;
        newDivisor = newDivisor<0 ? -newDivisor : newDivisor;

        while(newDividend-newDivisor>=0) {
            int x = 0;
            while(newDividend-(newDivisor<<x)>=0) {
                x++;
            }
            x--;
            result += 1l<<x;
            newDividend -= (newDivisor<<x);
        }

        if((dividend>0) != (divisor>0)) {
            result = -result;
        }

        return (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)result;
    }
}