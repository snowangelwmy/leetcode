/**
 * Test cases:
 * 1: Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

class Q42 {
    public int trap(int[] height) {
        if(height==null||height.length==0) {
            return 0;
        }
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        maxLeft[0] = height[0];
        for(int i=1; i<length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        maxRight[length-1] = height[length-1];
        for(int i=length-2; i>=0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        int water = 0;
        for(int i=0; i<length; i++) {
            water += Math.min(maxLeft[i], maxRight[i])-height[i];
        }
        return water;
    }
}