/**
 * Test cases:
 * 1: Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * 2: Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 */

import java.util.Arrays;

class Q849 {
    public int maxDistToClosest(int[] seats) {
        if(seats==null||seats.length==0) {
            return 0;
        }

        int[] distances = new int[seats.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        for(int i=0; i<seats.length; i++) {
            if(seats[i]==1) {
                for(int j=0; j<seats.length; j++) {
                    if(i!=j) {
                        distances[j] = Math.min(distances[j], Math.abs(i-j));
                    }
                }
            }
        }

        int maxDistance = 0;
        for(int i=0; i<seats.length; i++) {
            if(seats[i]==0) {
                maxDistance = Math.max(maxDistance, distances[i]);
            }
        }

        return maxDistance;
    }
}