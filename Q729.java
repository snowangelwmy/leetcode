/**
 * Test cases:
 * 1: MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation:
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 * 2: Input: ["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
 * [[],[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
 * Output: [null,true,false,true,true,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]
 */

import java.util.PriorityQueue;
import java.util.Arrays;

class MyCalendar {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    PriorityQueue<Interval> queue;

    public MyCalendar() {
        queue = new PriorityQueue<>((u, v) -> u.start - v.start);
    }

    public boolean book(int start, int end) {
        boolean bookable = true;
        Interval[] intervals = queue.toArray(new Interval[0]);
        //The Iterator provided in method iterator() is not guaranteed to traverse the elements of the priority queue in any particular order.
        //If you need ordered traversal, consider using Arrays.sort(pq.toArray()).
        Arrays.sort(intervals, queue.comparator());
        for(Interval interval : intervals) {
            if(interval.start>=end) {
                break;
            } else if(interval.end<=start) {
                continue;
            } else {//start<interval.end && end>interval.start
                bookable = false;
                break;
            }
        }

        if(bookable) {
            queue.offer(new Interval(start, end));
        }

        return bookable;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */