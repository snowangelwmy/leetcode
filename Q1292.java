/**
 * Test cases:
 * 1: Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * Output: 2
 * Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
 * 2: Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * Output: 0
 * 3: Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * Output: 3
 * 4: Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
 * Output: 2
 */

class Q1292 {
    //https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/discuss/451843/Java-PrefixSum-solution
    public int maxSideLength(int[][] mat, int threshold) {
        if(mat==null||mat.length==0||mat[0]==null||mat[0].length==0) {
            return 0;
        }

        int row = mat.length;
        int col = mat[0].length;
        int[][] prefixSum = new int[row+1][col+1];
        for(int i=1; i<=row; i++) {
            int sum = 0;
            for(int j=1; j<=col; j++) {
                sum += mat[i-1][j-1];
                prefixSum[i][j] = prefixSum[i-1][j] + sum;
            }
        }

        // Start from the largest side length
        for(int k=Math.min(row, col)-1; k>0; k--) {
            for(int i=1; i+k<=row; i++) {
                for(int j=1; j+k<=col; j++) {
                    if(prefixSum[i+k][j+k]-prefixSum[i-1][j+k]-prefixSum[i+k][j-1]+prefixSum[i-1][j-1]<=threshold) {
                        return k+1;
                    }
                }
            }
        }

        return 0;
    }
}