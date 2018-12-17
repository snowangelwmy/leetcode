/**
 * Test cases:
 * 1: Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 2: Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 3: Input: 23
 * Output: 4
 * Explanation: There are 5, 10, 15, and 20, for four multiples of 5. Paired with 2's from the even factors, this makes for four factors of 10, so: 23! has 4 zeros.
 * 4: Input: 100
 * Output: 24
 * Explanation: Because 100 ÷ 5 = 20, so, there are twenty multiples of 5 between 1 and 100.
 * But wait, actually 25 is 5×5, so each multiple of 25 has an extra factor of 5, e.g. 25 × 4 = 100，which introduces extra of zero.
 * So, we need know how many multiples of 25 are between 1 and 100? Since 100 ÷ 25 = 4, there are four multiples of 25 between 1 and 100.
 * Finally, we get 20 + 4 = 24 trailing zeroes in 100!
 * 5: Input: 4617
 * Output: 1151
 * Explanation: 5^1 : 4617 ÷ 5 = 923.4, so we get 923 factors of 5
 * 5^2 : 4617 ÷ 25 = 184.68, so we get 184 additional factors of 5
 * 5^3 : 4617 ÷ 125 = 36.936, so we get 36 additional factors of 5
 * 5^4 : 4617 ÷ 625 = 7.3872, so we get 7 additional factors of 5
 * 5^5 : 4617 ÷ 3125 = 1.47744, so we get 1 more factor of 5
 * 5^6 : 4617 ÷ 15625 = 0.295488, which is less than 1, so stop here.
 * Then 4617! has 923 + 184 + 36 + 7 + 1 = 1151 trailing zeroes.
 */

class Solution {
    public int trailingZeroes(int n) {
        if(n<0){
            return 0;
        }

        //n>=0
        int num = 0;
        for(long i=5L; n/i>0; i*=5){
            num += n/i;
        }

        return num;
    }
}