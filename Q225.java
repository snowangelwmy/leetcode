/**
 * Test cases:
 * 1: Input & Output:
 * MyStack stack = new MyStack();
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 */

import java.util.Queue;
import java.util.LinkedList;

class MyStack {

  private static final int NUM_OF_QUEUES = 2;
  private static final int TEMP_QUEUE_INDEX = 0;
  private static final int DATA_QUEUE_INDEX = 1;
  private Queue<Integer>[] queues;

  /** Initialize your data structure here. */
  public MyStack() {
    queues = new Queue[NUM_OF_QUEUES];
    for(int i=0; i<NUM_OF_QUEUES; i++){
      queues[i] = new LinkedList<>();
    }
  }

  /** Push element x onto stack. */
  public void push(int x) {
    Queue<Integer> dataQueue = queues[DATA_QUEUE_INDEX];
    dataQueue.add(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    Queue<Integer> dataQueue = queues[DATA_QUEUE_INDEX];
    if(dataQueue.size()==0){
      System.out.println("Empty stack, no data to pop!");
      return Integer.MIN_VALUE;
    }

    //dataQueue.size()>0
    Queue<Integer> tempQueue = queues[TEMP_QUEUE_INDEX];
    while(dataQueue.size()>1){
      tempQueue.add(dataQueue.poll());
    }
    int lastElement = dataQueue.poll();
    while(tempQueue.size()>0){
      dataQueue.add(tempQueue.poll());
    }
    return lastElement;
  }

  /** Get the top element. */
  public int top() {
    Queue<Integer> dataQueue = queues[DATA_QUEUE_INDEX];
    if(dataQueue.size()==0){
      System.out.println("Empty stack, no data to peek!");
      return Integer.MIN_VALUE;
    }

    //dataQueue.size()>0
    Queue<Integer> tempQueue = queues[TEMP_QUEUE_INDEX];
    while(dataQueue.size()>1){
      tempQueue.add(dataQueue.poll());
    }
    int lastElement = dataQueue.poll();
    while(tempQueue.size()>0){
      dataQueue.add(tempQueue.poll());
    }
    dataQueue.add(lastElement);
    return lastElement;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    Queue<Integer> dataQueue = queues[DATA_QUEUE_INDEX];
    return dataQueue.size()==0;
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */