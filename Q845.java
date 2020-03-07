/**
 * Test cases:
 * 1: Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * 2: Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 */

class Q845 {
    //https://leetcode.com/problems/longest-mountain-in-array/solution/
    public int longestMountain(int[] A) {
        if(A==null||A.length<3) {
            return 0;
        }

        int maxLen = -1;
        int start = 0;
        while(start<A.length-2) {
            int curLen = getLongestMountain(A, start);
            maxLen = Math.max(maxLen, curLen);
            start = curLen==-1? start+1 : start + curLen - 1;
        }
        return maxLen==-1? 0 : maxLen;
    }

    private int getLongestMountain(int[] A, int start) {
        int len = -1;
        int end = -1;
        int index = start;
        if(index+1<A.length && A[index+1]>A[index]) {
            while(index+1<A.length && A[index+1]>A[index]) {
                end = index+1;
                index++;
            }

            if(index+1<A.length&&A[index+1]<A[index]) {
                while(index+1<A.length && A[index+1]<A[index]) {
                    end = index+1;
                    index++;
                }
                len = end - start + 1;
            }
        }

        return len;
    }
}