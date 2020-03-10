/**
 * Test cases:
 * 1: Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 2: Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */

import java.util.Map;
import java.util.HashMap;

class Q992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        if(A==null||A.length==0) {
            return 0;
        }

        int totalCount = 0;
        int count = 0;
        int left = 0;
        Map<Integer, Integer> lookup = new HashMap<>();
        for(int right=0; right<A.length; right++) {
            if(lookup.containsKey(A[right])) {
                lookup.put(A[right], lookup.get(A[right])+1);
            } else {
                if(lookup.size()<K) {
                    lookup.put(A[right], 1);
                } else {//lookup.size()==K
                    lookup.remove(A[left++]);
                    lookup.put(A[right], 1);
                    count = 0;
                }
            }

            if(lookup.size()<K) {
                continue;
            }

            if(lookup.size()==K) {
                if(count==0) {
                    count++;
                }

                while(lookup.size()==K) {
                    if(lookup.get(A[left])>1) {
                        lookup.put(A[left], lookup.get(A[left])-1);
                        left++;
                    } else {
                        lookup.remove(A[left]);
                        left++;
                    }
                    if(lookup.size()==K) {
                        count++;
                    }
                }
                --left;
                lookup.put(A[left], 1);
            }

            totalCount += count;
        }

        return totalCount;
    }
}