/**
 * Test cases:
 * 1: Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 */

class Q907 {
    //https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C++JavaPython-Stack-Solution
    public int sumSubarrayMins(int[] A) {
        long sum = 0L;
        int length = A.length;
        for(int i=0; i<length; i++) {
            int left = 1;
            int right = 1;
            for(int j=i-1; j>=0; j--) {
                if(A[j]<=A[i]) {
                    break;
                }
                left++;
            }
            for(int j=i+1; j<length; j++) {
                if(A[j]<A[i]) {
                    break;
                }
                right++;
            }
            sum += A[i]*(left*right);
        }

        return (int)(sum%(Math.pow(10,9)+7));
    }
}