/**
 * Test cases:
 * 1: Input && Output:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(1)
 * obj.addNum(2)
 * obj.findMedian() -> 1.5
 * obj.addNum(3)
 * obj.findMedian() -> 2
 */

import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    private static final int INITIAL_CAPACITY = 1000;
    private PriorityQueue<Integer> lowHalf; //max_heap
    private PriorityQueue<Integer> highHalf; //min_heap


    /** initialize your data structure here. */
    public MedianFinder() {
        this.lowHalf = new PriorityQueue<Integer>(INITIAL_CAPACITY, Collections.reverseOrder());
        this.highHalf = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        this.lowHalf.add(num);
        this.highHalf.add(this.lowHalf.poll());

        if(this.highHalf.size() > this.lowHalf.size()) {
            this.lowHalf.add(this.highHalf.poll());
        }
    }

    public double findMedian() {
        if(this.lowHalf.size() > this.highHalf.size()) {
            return this.lowHalf.peek();
        } else {
            return (this.lowHalf.peek() + this.highHalf.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */