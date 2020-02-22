/**
 * Test cases:
 * 1: Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 2: Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */

import java.util.Comparator;
import java.util.Arrays;

class Q973 {

    class PointWithDist {
        int[] points;
        long dist;

        PointWithDist(int[] points, long dist) {
            this.points = points;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if(points==null||points.length<=K) {
            return points;
        }

        PointWithDist[] pointsWithDist = new PointWithDist[points.length];
        for(int i=0; i<points.length; i++) {
            long dist = (points[i][0]-0)*(points[i][0]-0)+(points[i][1]-0)*(points[i][1]-0);
            pointsWithDist[i] = new PointWithDist(points[i], dist);
        }

        Arrays.sort(pointsWithDist, new Comparator<PointWithDist>() {
            public int compare(PointWithDist a, PointWithDist b) {
                if(a.dist > b.dist) {
                    return 1;
                } else if(a.dist < b.dist) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int[][] kPoints = new int[K][2];
        for(int i=0; i<K; i++) {
            kPoints[i][0] = pointsWithDist[i].points[0];
            kPoints[i][1] = pointsWithDist[i].points[1];
        }
        return kPoints;
    }
}