/**
 * Test cases:
 * 1: Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 2: Input: A = [0,0,0,0,0], S = 0
 * Output: 15
 * 3: Input: A = [0,1,1,1,1], S = 3
 * Output: 3
 */

class Q930 {
    //https://leetcode.com/problems/binary-subarrays-with-sum/solution/
    public int numSubarraysWithSum(int[] A, int S) {
        if(A==null||A.length==0) {
            return 0;
        }

        int[] prefixSums = new int[A.length+1];
        for(int i=0; i<A.length; i++) {
            prefixSums[i+1] = prefixSums[i] + A[i];
        }

        int count = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<=i; j++) {
                if(prefixSums[i+1]-prefixSums[j]==S) {
                    count++;
                }
            }
        }

        return count;
    }
}