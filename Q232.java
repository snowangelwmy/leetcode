/**
 * Test cases:
 * 1: Input & Output:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 */

import java.util.Stack;

class MyQueue {

  private Stack<Integer> frontStack;
  private Stack<Integer> tailStack;

  /** Initialize your data structure here. */
  public MyQueue() {
    frontStack = new Stack<>();
    tailStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    tailStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if(frontStack.size()>0){
      return frontStack.pop();
    }

    //frontStack.size()==0
    while(tailStack.size()>0){
      frontStack.push(tailStack.pop());
    }

    if(frontStack.size()>0){
      return frontStack.pop();
    } else {
      System.out.println("Empty stack, no data to pop!");
      return Integer.MIN_VALUE;
    }
  }

  /** Get the front element. */
  public int peek() {
    if(frontStack.size()>0){
      return frontStack.peek();
    }

    //frontStack.size()==0
    while(tailStack.size()>0){
      frontStack.push(tailStack.pop());
    }

    if(frontStack.size()>0){
      return frontStack.peek();
    } else {
      System.out.println("Empty stack, no data to peek!");
      return Integer.MIN_VALUE;
    }
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return frontStack.size()==0 && tailStack.size()==0;
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */