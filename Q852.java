/**
 * Test cases:
 * 1: Input: [0,1,0]
 * Output: 1
 * 2: Input: [0,2,1,0]
 * Output: 1
 */

class Q852 {
    public int peakIndexInMountainArray(int[] A) {
        if(A==null||A.length<3) {
            return -1;
        }

        for(int i=1; i<A.length-1; i++) {
            if(A[i]>A[i-1]&&A[i]>A[i+1]) {
                return i;
            }
        }

        return -1;
    }
}