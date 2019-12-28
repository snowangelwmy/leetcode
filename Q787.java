/**
 * Test cases:
 * 1: Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *              0
 *        100 /  \ 500
 *          1 ---> 2
 *            100
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200 (0 -> 1 -> 2), as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *              0
 *        100 /  \ 500
 *          1 ---> 2
 *            100
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500 (0 -> 2), as marked blue in the picture.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Q787 {
  //https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if(flights==null||flights.length==0) {
      return -1;
    }

    Map<Integer, List<int[]>> neighbors = new HashMap<>();
    for(int i=0; i<flights.length; i++) {
      int[] flight = flights[i];
      neighbors.putIfAbsent(flight[0], new ArrayList<int[]>());
      neighbors.get(flight[0]).add(new int[] {flight[1], flight[2]});
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {src, 0});
    int max = Integer.MAX_VALUE;
    int step = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      for(int i=0; i<size; i++) {
        int[] cur = queue.poll();
        if(cur[0]==dst) {
          max = Math.min(max, cur[1]);
        }
        List<int[]> nexts = neighbors.get(cur[0]);
        if(nexts==null) {
          continue;
        }
        for(int[] next : nexts) {
          if(cur[1]+next[1]>=max) {
            continue;
          }
          queue.offer(new int[]{next[0], cur[1]+next[1]});
        }
      }
      if(step>K) {
        break;
      }
      step++;
    }

    return max == Integer.MAX_VALUE ? -1 : max;
  }
}