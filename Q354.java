/**
 * Test cases:
 * 1: Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 2: Input: [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
 * Output: 5
 * Explanation: The maximum number of envelopes you can Russian doll is 5 ([2,100] => [3,200] => [5,250] => [6,360] => [7,380]).
 * 3: Input: [[46,89],[50,53],[52,68],[72,45],[77,81]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([50,53] => [52,68] => [77,81]).
 */

import java.util.Arrays;
import java.util.Comparator;

class Q354 {
    //https://www.cnblogs.com/grandyang/p/5568818.html
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1];
            }
        });

        int maxLen = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<envelopes.length; i++) {
            int[] cur = envelopes[i];
            for(int j=0; j<i; j++) {
                int[] pre = envelopes[j];
                if(cur[0]>pre[0]&&cur[1]>pre[1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}