/**
 * Test cases:
 * 1: Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 2: Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

import java.util.List;
import java.util.ArrayList;

class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> lefts = new ArrayList<>();
        List<int[]> rights = new ArrayList<>();
        for(int[] interval : intervals) {
            if(interval[1] < start) {
                lefts.add(interval);
            } else if(interval[0] > end) {
                rights.add(interval);
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        List<int[]> result = new ArrayList<>(lefts);
        result.add(new int[]{start, end});
        result.addAll(rights);
        return result.toArray(new int[0][0]);
    }
}