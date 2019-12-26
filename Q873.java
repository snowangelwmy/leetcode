/**
 * Test cases:
 * 1: Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * 2: Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Q873 {

  // Approach 2: Dynamic Programming
  public int lenLongestFibSubseq(int[] A) {
    if(A==null||A.length<=2) {
      return 0;
    }

    int N = A.length;
    Map<Integer, Integer> valueLookup = new HashMap<>();
    for(int i=0; i<N; i++) {
      valueLookup.put(A[i], i);
    }

    Map<Integer, Integer> lenLookup = new HashMap<>();

    int max = 0;
    for(int k=2; k<N; k++) {
      for(int j=1; j<k; j++) {
        int i = valueLookup.getOrDefault(A[k]-A[j], -1);
        if(i>=0 && i<j) {
          int key = j*N+k;
          int value = lenLookup.getOrDefault(i*N+j, 2)+1;
          lenLookup.put(key, value);
          max = Math.max(max, value);
        }
      }
    }

    return max<3 ? 0 : max;
  }

  // Approach 1: Brute Force with Set
  public int lenLongestFibSubseq0(int[] A) {
    if(A==null||A.length<=2) {
      return 0;
    }

    Set<Integer> lookup = new HashSet<>();
    for(int a : A) {
      lookup.add(a);
    }

    int max = 0;
    for(int i=0; i<A.length-2; i++) {
      for(int j=i+1; j<A.length-1; j++) {
        int xi = A[i];
        int xi1 = A[j];
        int xi2 = xi + xi1;
        int length = 2;
        while(lookup.contains(xi2)) {
          length++;
          max = Math.max(max, length);
          xi = xi1;
          xi1 = xi2;
          xi2 = xi + xi1;
        }
      }
    }

    return max<3 ? 0 : max;
  }
}