/**
 * Test cases:
 * 1: Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 2: Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 3: Input: [[1,4],[2,3]]
 * Output: [[1,4]]
 *
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Q56 {

    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            int compareStart = compareInt(a.start, b.start);
            return compareStart!=0 ? compareStart : compareInt(a.end, b.end);
        }

        private int compareInt(int a, int b) {
            return a > b ? 1 : (a < b ? -1 : 0);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if(intervals==null||intervals.size()==0) {
            return mergedIntervals;
        }

        intervals.sort(new IntervalComparator());
        mergedIntervals.add(intervals.get(0));
        int lastIdx = 0;
        for(int i=1; i<intervals.size(); i++) {
            Interval last = mergedIntervals.get(lastIdx);
            Interval current = intervals.get(i);
            if(current.start <= last.end) {
                if(current.end > last.end) {
                    mergedIntervals.remove(lastIdx);
                    mergedIntervals.add(new Interval(last.start, current.end));
                }
            } else { //current.start > last.end
                mergedIntervals.add(current);
                lastIdx++;
            }
        }
        return mergedIntervals;
    }
}