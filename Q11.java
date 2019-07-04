/**
 * Test cases:
 * 1: Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */


import java.lang.Math;

class Q11 {
    //two pointers solution, time complexity: O(n), space complexity: O(1)
    public int maxArea(int[] height) {
        int maxArea = 0;
        if(height==null||height.length==0) {
            return maxArea;
        }

        int low = 0, high = height.length-1;
        while(low < high) {
            maxArea = Math.max(maxArea, (high-low) * Math.min(height[low], height[high]));
            if(height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }


    //brute force solution, time complexity: O(n^2), space complexity: O(1)
    public int maxArea1(int[] height) {
        int maxArea = 0;
        if(height==null||height.length==0) {
            return maxArea;
        }

        for(int i=0; i<height.length; i++) {
            for(int j=i+1; j<height.length; j++) {
                maxArea = Math.max(maxArea, (j-i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }
}