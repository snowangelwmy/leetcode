/**
 * Test cases:
 * 1: Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * Output:
 * 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

import java.util.Map;
import java.util.HashMap;

class Q454 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    if(A==null||A.length==0||B==null||B.length==0||C==null||C.length==0||D==null||D.length==0) {
      return 0;
    }

    Map<Integer, Integer> abSumCount = new HashMap<>();
    for(int i=0; i<A.length; i++) {
      for(int j=0; j<B.length; j++) {
        abSumCount.put(A[i]+B[j], abSumCount.getOrDefault(A[i]+B[j],0)+1);
      }
    }

    int totalCount = 0;
    Map<Integer, Integer> cCount = new HashMap<>();
    for(int i=0; i<C.length; i++) {
      if(cCount.containsKey(C[i])) {
        totalCount += cCount.get(C[i]);
        continue;
      }

      int count = 0;
      for(int j=0; j<D.length; j++) {
        count += abSumCount.getOrDefault(0-C[i]-D[j],0);
      }
      cCount.put(C[i], count);
      totalCount += count;
    }
    return totalCount;
  }
}