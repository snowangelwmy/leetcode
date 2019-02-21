/**
 * Test cases:
 * 1: Input:
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [3,2,4,4],
 *   [1,3,2,4],
 *   [2,3,3,4]
 * ]
 * Output: true
 * Explanation: All 5 rectangles together form an exact cover of a rectangular region.
 * 2: Input:
 * rectangles = [
 *   [1,1,2,3],
 *   [1,3,2,4],
 *   [3,1,4,2],
 *   [3,2,4,4]
 * ]
 * Output: false
 * Explanation: Because there is a gap between the two rectangular regions.
 * 3: Input:
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [3,2,4,4]
 * ]
 * Output: false
 * Explanation: Because there is a gap in the top center.
 * 4: Input:
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [2,2,4,4]
 * ]
 * Output: false
 * Explanation: Because two of the rectangles overlap with each other.
 */

import java.util.Set;
import java.util.HashSet;

class Q391 {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles==null||rectangles.length==0||rectangles[0]==null||rectangles[0].length==0) {
            return false;
        }

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        Set<String> points = new HashSet<>();
        int area = 0;

        for(int[] rectangle : rectangles) {
            x1 = Math.min(rectangle[0], x1);
            y1 = Math.min(rectangle[1], y1);
            x2 = Math.max(rectangle[2], x2);
            y2 = Math.max(rectangle[3], y2);

            area += (rectangle[2]-rectangle[0]) * (rectangle[3]-rectangle[1]);

            String bottomLeft = rectangle[0] + "," + rectangle[1];
            String topLeft = rectangle[0] + "," + rectangle[3];
            String topRight = rectangle[2] + "," + rectangle[3];
            String bottomRight = rectangle[2] + "," + rectangle[1];

            if(!points.add(bottomLeft)) { points.remove(bottomLeft); }
            if(!points.add(topLeft)) { points.remove(topLeft); }
            if(!points.add(topRight)) { points.remove(topRight); }
            if(!points.add(bottomRight)) { points.remove(bottomRight); }
        }

        //you need to have parentheses () for !(points.size()==4).
        if(!(points.size()==4)||!points.contains(x1+","+y1)||!points.contains(x1+","+y2)||!points.contains(x2+","+y2)||!points.contains(x2+","+y1)) {
            return false;
        }

        return area == ((x2-x1)*(y2-y1));
    }
}