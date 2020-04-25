/**
 * Test cases:
 * 1: Input: A = [9,1,2,3,9], K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 * 2: Input: A = [1,2,3,4,5,6,7], K = 4
 * Output: 20.5
 */

class Q813 {
    //https://leetcode.com/problems/largest-sum-of-averages/solution/
    public double largestSumOfAverages(int[] A, int K) {
        if(A==null||A.length==0||K<1) {
            return 0.0;
        }

        double[][] memo = new double[A.length][K];
        int[] prefixSums = new int[A.length+1];
        prefixSums[0] = 0;
        for(int i=0; i<A.length; i++) {
            prefixSums[i+1] = prefixSums[i] + A[i];
        }
        return largestSumOfAveragesHelper(A, K, 0, memo, prefixSums);
    }

    private double largestSumOfAveragesHelper(int[] A, int K, int index, double[][] memo, int[] prefixSums) {
        if(index==A.length) {
            return 0.0;
        }

        if(memo[index][K-1]!=0.0) {
            return memo[index][K-1];
        }

        double maxSum = (prefixSums[A.length]-prefixSums[index])/(double)(A.length-index);
        if(K==1) {
            memo[index][K-1] = maxSum;
            return memo[index][K-1];
        }

        //K>1
        for(int i=index+1; i<A.length; i++) {
            double curAve = (prefixSums[i]-prefixSums[index])/(double)(i-index);
            double subSum = largestSumOfAveragesHelper(A, K-1, i, memo, prefixSums);
            maxSum = Math.max(maxSum, curAve + subSum);
        }
        memo[index][K-1] = maxSum;

        return memo[index][K-1];
    }
}