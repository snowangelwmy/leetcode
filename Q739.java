/**
 * Test cases:
 * 1: Input: T = [73, 74, 75, 71, 69, 72, 76, 73]
 * Output: [1, 1, 4, 2, 1, 1, 0, 0]
 */

import java.util.Stack;

class Q739 {

    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0) {
            return null;
        }

        if(T.length==1) {
            return new int[]{0};
        }

        int[] result = new int[T.length];
        Stack<Integer> maxLookup = new Stack<>();
        for(int i=T.length-1; i>=0; i--) {
            while(!maxLookup.isEmpty() && T[i]>=T[maxLookup.peek()]) {
                maxLookup.pop();
            }
            result[i] = maxLookup.isEmpty() ? 0 : maxLookup.peek()-i;
            maxLookup.push(i);
        }

        return result;
    }

    //Time Limit Exceeded
    public int[] dailyTemperatures0(int[] T) {
        if(T==null||T.length==0) {
            return null;
        }

        if(T.length==1) {
            return new int[]{-1};
        }

        int[] result = new int[T.length];
        for(int i=0; i<T.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(T[i]>T[j] && result[j]==0) {
                    result[j] = i - j;
                }
            }
        }
        return result;
    }
}