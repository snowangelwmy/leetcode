/**
 * Test cases:
 * 1: Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 */

class Q812 {
    //https://leetcode.com/problems/largest-triangle-area/solution/
    public double largestTriangleArea(int[][] points) {
        if(points==null||points.length<3) {
            return 0;
        }

        double maxArea = 0.0;
        for(int i=0; i<points.length-2; i++) {
            for(int j=i+1; j<points.length-1; j++) {
                for(int k=j+1; k<points.length; k++) {
                    double area = calculateArea(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private double calculateArea(int[] point1, int[] point2, int[] point3) {
        return 0.5 * Math.abs(point1[0]*point2[1]+point2[0]*point3[1]+point3[0]*point1[1]-point2[0]*point1[1]-point3[0]*point2[1]-point1[0]*point3[1]);
    }
}