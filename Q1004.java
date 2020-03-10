/**
 * Test cases:
 * 1: Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1] from index 5 to index 10.
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * 2: Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] from index 2 to index 11.
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */

class Q1004 {
    public int longestOnes(int[] A, int K) {
        if(A==null||A.length==0) {
            return 0;
        }

        int maxLen = 0;
        int left = 0;
        for(int right=0; right<A.length; right++) {
            if(A[right]==1) {
                continue;
            }
            //A[right]==0
            if(K>0) {
                K--;
                continue;
            }

            //A[right]==0&&K==0
            right--;
            maxLen = Math.max(maxLen, right-left+1);
            while(K==0) {
                K += A[left] == 0 ? 1 : 0;
                left++;
            }
        }

        maxLen = Math.max(maxLen, A.length-left);
        return maxLen;
    }
}