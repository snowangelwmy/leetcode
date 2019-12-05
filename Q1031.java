/**
 * Test cases:
 * 1: Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * Output: 20
 * Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
 * 2: Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * Output: 29
 * Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
 * 3: Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * Output: 31
 * Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
 */

class Q1031 {
  // Solution: https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/290299/Java-O(n)-very-easy-to-understand-solution
  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    int[] prefixSum = new int[A.length];
    prefixSum[0] = A[0];
    for(int i=1; i<A.length; i++) {
      prefixSum[i] = prefixSum[i-1] + A[i];
    }
    return Math.max(maxSumTwoNoOverlapHelper(A, L, M, prefixSum), maxSumTwoNoOverlapHelper(A, M, L, prefixSum));
  }

  private int maxSumTwoNoOverlapHelper(int[] A, int L, int M, int[] prefixSum) {
    int[] leftSumMax = new int[A.length];
    int[] rightSumMax = new int[A.length];

    for(int i=L-1; i<A.length; i++) {
      int curLeftSum = prefixSum[i] - prefixSum[i-L+1] + A[i-L+1];
      if(i==L-1) {
        leftSumMax[i] = curLeftSum;
      } else {
        leftSumMax[i] = Math.max(leftSumMax[i-1], curLeftSum);
      }
    }

    for(int i=A.length-M; i>=0; i--) {
      int curRightSum = prefixSum[i+M-1] - prefixSum[i] + A[i];
      if(i==A.length-M) {
        rightSumMax[i] = curRightSum;
      } else {
        rightSumMax[i] = Math.max(rightSumMax[i+1], curRightSum);
      }
    }

    int maxSum = Integer.MIN_VALUE;
    for(int i=L-1; i<A.length-M; i++) {
      maxSum = Math.max(leftSumMax[i]+rightSumMax[i+1], maxSum);
    }
    return maxSum;
  }
}