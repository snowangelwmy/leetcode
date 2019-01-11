/**
 * Test cases:
 * 1: Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * 2: Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */

import java.util.Arrays;
import java.lang.Math;

class Q475 {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int[] radius = new int[houses.length];
    for(int i=0; i<radius.length; i++) {
      radius[i] = Integer.MAX_VALUE;
    }
    //find the nearest heater from RHS
    for(int i=0, j=0; i<houses.length && j<heaters.length; ) {
      if(houses[i]<=heaters[j]) {
        radius[i] = heaters[j] - houses[i];
        i++;
      } else {//houses[i]>heaters[j]
        j++;
      }
    }

    //find the nearest heater from LHS
    for(int i=houses.length-1, j=heaters.length-1; i>=0 && j>=0; ) {
      if(houses[i]>=heaters[j]) {
        radius[i] = Math.min(radius[i], houses[i]-heaters[j]);
        i--;
      } else {//houses[i]<heaters[j]
        j--;
      }
    }

    int maxRadius = radius[0];
    for(int i=1; i<radius.length; i++) {
      maxRadius = Math.max(maxRadius, radius[i]);
    }

    return maxRadius;
  }
}