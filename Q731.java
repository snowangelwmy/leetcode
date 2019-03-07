/**
 * Test cases:
 * 1: Input & Output:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * Explanation:
 * The first two events can be booked.  The third event can be double booked.
 * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
 * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
 * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
 * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 */

import java.util.TreeMap;

class MyCalendarTwo {
    private TreeMap<Integer, Integer> bookings;

    public MyCalendarTwo() {
        bookings = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        //temporarily add the booking
        bookings.put(start, bookings.getOrDefault(start, 0)+1);
        bookings.put(end, bookings.getOrDefault(end, 0)-1);

        int active = 0;
        for(int booking : bookings.values()) {
            active += booking;
            if(active>=3) {
                //cancel the booking since it is causing triple bookings
                bookings.put(start, bookings.get(start)-1);
                bookings.put(end, bookings.get(end)+1);
                if(bookings.get(start)==0) {
                    bookings.remove(start);
                }
                if(bookings.get(end)==0) {
                    bookings.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */