/**
 * Test cases:
 * 1: Input: n = 2
 * Output: 8
 * Explanation:
 *   There are 8 records with length 2 will be regarded as rewardable:
 *   "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 *   Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * 2: Input: n = 100
 * Output: 985598218
 */

class Q552 {
    public int checkRecord(int n) {
        int divisor = 1000000007;
        int[][][] lookup = new int[n+1][2][3];
        //lookup[i][j][k] denote the # of valid sequences of length i where:
        //  There can be at most j A's in the entire sequence.
        //  There can be at most k trailing L's.
        lookup[0] = new int[][] {
                {1, 1, 1},
                {1, 1, 1}
        };

        for(int i=1; i<=n; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<3; k++) {
                    int value = lookup[i-1][j][2]; // ..P
                    if(j>0) value = (value + lookup[i-1][j-1][2]) % divisor; //..A Attention: avoid integer overflow
                    if(k>0) value = (value + lookup[i-1][j][k-1]) % divisor; //..L Attention: avoid integer overflow
                    lookup[i][j][k] = value;
                }
            }
        }

        return lookup[n][1][2];
    }
}