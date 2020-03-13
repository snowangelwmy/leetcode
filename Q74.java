/**
 * Test cases:
 * 1: Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 2: Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */


class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row*col-1;
        int mid, midRow, midCol;
        while(low<=high) {
            mid = (low+high)/2;
            midRow = mid/col;
            midCol = mid%col;
            if(matrix[midRow][midCol]==target) {
                return true;
            } else if(matrix[midRow][midCol]<target) {
                low=mid+1;
            } else {//matrix[midRow][midCol]>target
                high=mid-1;
            }
        }
        return false;
    }
}