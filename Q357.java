/**
 * Test cases:
 * 1: Input: 0
 * Output: 1
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 1,
 *              which is 0
 * 2: Input: 1
 * Output: 10
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 10,
 *              which are 0,1,2,3,4,5,6,7,8,9
 * 3: Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 */


class Q357 {
    //https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/281367/JAVA-O(1)-clean-solution-beat-100.
    public int countNumbersWithUniqueDigits(int n) {
        if(n<0) {
            return 0;
        }

        if(n==0) {
            return 1;
        }

        int result = 10;
        int numOfDigits = 1;
        int numOfUniqueDigits = 9;
        while(numOfDigits<n) {
            //count how many numbers with x number of digits are having unique digits
            numOfUniqueDigits = numOfUniqueDigits * (10 - numOfDigits);
            result += numOfUniqueDigits;
            numOfDigits++;
        }

        return result;
    }
}