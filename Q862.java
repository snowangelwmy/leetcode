/**
 * Test cases:
 * 1: Input: A = [1], K = 1
 * Output: 1
 * 2: Input: A = [1,2], K = 4
 * Output: -1
 * 3: Input: A = [2,-1,2], K = 3
 * Output: 3
 * 4: Input: A = [-28,81,-20,28,-29], K = 89
 * Output: 3
 */

import java.util.Deque;
import java.util.ArrayDeque;

class Q862 {

    //prefixSum and sliding window solution
    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
    public int shortestSubarray(int[] A, int K) {
        if(A==null||A.length==0) {
            return -1;
        }

        int[] prefixSums = new int[A.length+1];
        for(int i=0; i<A.length; i++) {
            prefixSums[i+1] = prefixSums[i] + A[i];
        }

        int minLen = Integer.MAX_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<prefixSums.length; i++) {
            while(q.size()>0 && prefixSums[i]-prefixSums[q.getFirst()]>=K) {
                minLen = Math.min(minLen, i-q.getFirst());
                q.pollFirst();
            }
            while(q.size()>0 && prefixSums[i]<prefixSums[q.getLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    //Time Limit Exceeded
    public int shortestSubarray0(int[] A, int K) {
        if(A==null||A.length==0) {
            return -1;
        }

        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            int sum = 0;
            for(int j=i; j<A.length && j<i+(long)minLen; j++) {
                sum += A[j];
                if(sum >= K) {
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE? -1 : minLen;
    }
}