/**
 * Test cases:
 * 1: Input & Output:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

import java.util.Stack;
import java.lang.Math;

class MinStack {
    private Stack<Integer> nums;
    private Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
        nums = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        nums.push(x);
        if(mins.isEmpty()){
            mins.push(x);
        } else {
            int min = Math.min(mins.peek(),x);
            mins.push(min);
        }
    }

    public void pop() {
        if(!nums.isEmpty()){
            nums.pop();
            mins.pop();
        }
    }

    public int top() {
        if(!nums.isEmpty()){
            return nums.peek();
        }

        System.out.println("Error: Stack is empty!");
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if(!mins.isEmpty()){
            return mins.peek();
        }

        System.out.println("Error: Stack is empty!");
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */