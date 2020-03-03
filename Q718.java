/**
 * Test cases:
 * 1: Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 */

class Q718 {
    public int findLength(int[] A, int[] B) {
        if(A==null||A.length==0||B==null||B.length==0) {
            return 0;
        }

        int maxLen = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                if(A[i]==B[j]) {
                    int curLen = getLength(A, i, B, j);
                    maxLen = Math.max(maxLen, curLen);
                }
            }
        }

        return maxLen;
    }

    private int getLength(int[] A, int startA, int[] B, int startB) {
        int len = 0;
        int j = startB;
        for(int i=startA; i<A.length; i++) {
            if(j>=B.length||A[i]!=B[j]) {
                break;
            }
            j++;
            len++;
        }
        return len;
    }
}