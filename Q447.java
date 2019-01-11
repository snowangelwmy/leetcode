/**
 * Test cases:
 * 1: Input: [[0,0],[1,0],[2,0]]
 * Output: 2
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 2: Input: [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
 * Output: 20
 */

import java.util.Map;
import java.util.HashMap;

class Q447 {
  public int numberOfBoomerangs(int[][] points) {
    int count = 0;
    if(points==null||points.length==0){
      return count;
    }

    for(int i=0; i<points.length; i++){
      Map<Integer, Integer> lookup = new HashMap<>();
      for(int j=0; j<points.length; j++){
        if(j==i){
          continue;
        }
        int distance = calculateDistance(points[i], points[j]);
        lookup.put(distance, lookup.getOrDefault(distance, 0)+1);
      }

      for(int value : lookup.values()) {
        count += value * (value-1);
      }
    }

    return count;
  }

  private int calculateDistance(int[] start, int[] end) {
    int dx = start[0]-end[0];
    int dy = start[1]-end[1];
    return dx*dx+dy*dy;
  }
}