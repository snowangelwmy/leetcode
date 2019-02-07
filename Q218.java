/**
 * Test cases:
 * 1: Input: [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]
 * Output: [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Q218 {
    public class PointComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] height1, int[] height2) {
            return (height1[0]!=height2[0]) ? (height1[0]-height2[0]) : (height1[1]-height2[1]);
        }
    }


    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> keyPoints = new ArrayList<>();
        List<int[]> criticalPoints = new ArrayList<>();
        for(int[] building : buildings) {
            criticalPoints.add(new int[]{building[0], -building[2]});
            criticalPoints.add(new int[]{building[1], building[2]});
        }
        criticalPoints.sort(new PointComparator());
        PriorityQueue<Integer> activeHeights = new PriorityQueue<>((a,b) -> (b-a));
        activeHeights.add(0);
        int previousHeight = 0;
        for(int[] point : criticalPoints) {
            if(point[1]<0) {
                activeHeights.add(-point[1]);
            } else {
                activeHeights.remove(point[1]);
            }
            int currentHeight = activeHeights.peek();
            if(currentHeight!=previousHeight) {
                keyPoints.add(new int[]{point[0], currentHeight});
                previousHeight = currentHeight;
            }
        }
        return keyPoints;
    }
}