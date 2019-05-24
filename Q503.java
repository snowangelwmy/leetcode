/**
 * Test cases:
 * 1: Input: [1, 2, 1]
 * Output: [2, -1, 2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * 2: Input: [3, 8, 4, 1, 2]
 * Output: [8, -1, 8, 2, 3]
 */

import java.util.Stack;

class Q503 {

    public int[] nextGreaterElements(int[] nums) {
        if(nums==null) {
            return null;
        }

        int[] res = new int[nums.length];
        Stack<Integer> lookup = new Stack<>();
        for(int i=2*nums.length-1; i>=0; i--) {
            while(!lookup.isEmpty() && nums[lookup.peek()] <= nums[i%nums.length]) {
                lookup.pop();
            }
            res[i%nums.length] = lookup.isEmpty() ? -1 : nums[lookup.peek()];
            lookup.push(i%nums.length);
        }
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {
        if(nums==null) {
            return null;
        }

        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            res[i] = -1;
            for(int j=1; j<nums.length; j++) {
                if(nums[(i+j) % nums.length] > nums[i]) {
                    res[i] = nums[(i+j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}