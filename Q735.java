/**
 * Test cases:
 * 1: Input: asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * 2: Input: asteroids = [8, -8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * 3: Input: asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * 4: Input: asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 */

import java.util.Stack;

class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids==null||asteroids.length==0) {
            return asteroids;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroids.length; i++) {
            if(asteroids[i]>0) {
                stack.push(new Integer(asteroids[i]));
            } else if(asteroids[i]<0){
                if(stack.isEmpty()) {
                    stack.push(asteroids[i]);
                } else {
                    boolean explode = false;
                    while(!stack.isEmpty()) {
                        int cur = stack.peek();
                        if(cur<0) {
                            explode = false;
                            break;
                        } else if(cur>Math.abs(asteroids[i])) {
                            explode = true;
                            break;
                        } else if(cur==Math.abs(asteroids[i])) {
                            stack.pop();
                            explode = true;
                            break;
                        } else { //cur<Math.abs(asteroids[i])
                            stack.pop();
                            explode = false;
                        }
                    }
                    if(!explode) {
                        stack.push(new Integer(asteroids[i]));
                    }
                }
            }
        }

        int[] result = new int[stack.size()];
        int idx = result.length-1;
        while(!stack.isEmpty()) {
            result[idx--] = stack.pop();
        }
        return result;
    }
}