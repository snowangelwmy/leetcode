/**
 * Test cases:
 * 1: Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 2: Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 */

import java.util.Stack;

class Q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(popped==null||popped.length==0) {
            return true;
        }

        if(pushed==null||pushed.length==0) {
            return false;
        }

        //popped.length>0 && pushed.length>0
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        int popIdx = 0;
        Integer top = null;
        while(popIdx<popped.length) {
            while((top==null||top!=popped[popIdx])&&pushIdx<pushed.length) {
                stack.push(pushed[pushIdx++]);
                top = stack.peek();
            }
            if(top!=popped[popIdx]) {//pushIdx==pushed.length
                return false;
            }
            stack.pop();
            popIdx++;
            top = stack.isEmpty() ? null : stack.peek();
        }

        return true;
    }
}