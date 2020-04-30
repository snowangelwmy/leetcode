/**
 * Test cases:
 * 1: Input: [[4,3,8,4],
 *         [9,5,1,9],
 *         [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * while this one is not:
 * 384
 * 519
 * 762
 * In total, there is only one magic square inside the given grid.
 * 2: Input: [[10,3,5],
 *         [1,6,11],
 *         [7,9,2]]
 * Output: 0
 */

import java.util.Set;
import java.util.HashSet;

class Q840 {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid==null||grid.length<3||grid[0]==null||grid[0].length<3) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<=grid.length-3; i++) {
            for(int j=2; j<grid[0].length; j++) {
                if(!allDistinctNums(grid, i, j)||
                        !hasSameSum(grid, i, j)) {
                    continue;
                }
                count++;
            }
        }

        return count;
    }

    //check if all cells having different numbers
    private boolean allDistinctNums(int[][] grid, int i, int j) {
        Set<Integer> nums = new HashSet<>();
        for(int k=i; k<i+3; k++) {
            for(int l=j-2; l<=j; l++) {
                if(grid[k][l]>=1&&grid[k][l]<=9) {
                    nums.add(grid[k][l]);
                }
            }
        }
        return nums.size() == 9;
    }


    private boolean hasSameSum(int[][] grid, int i, int j) {
        Integer sum = null;

        //check if each row has the same sum
        for(int k=i; k<i+3; k++) {
            int curSum = 0;
            for(int l=j-2; l<=j; l++) {
                curSum += grid[k][l];
            }

            if(sum==null) {
                sum = curSum;
            } else if(sum!=curSum){
                return false;
            }
        }

        //check if each column has the same sum 
        for(int l=j-2; l<=j; l++) {
            int curSum = 0;
            for(int k=i; k<i+3; k++) {
                curSum += grid[k][l];
            }

            if(sum!=curSum){
                return false;
            }
        }

        //check if each diagonal has the same sum
        int curSum = 0;
        for(int k=i, l=j-2; k<i+3&&l<=j; k++, l++) {
            curSum += grid[k][l];
        }
        if(sum!=curSum){
            return false;
        }

        curSum = 0;
        for(int k=i, l=j; k<i+3&&l>=j-2; k++, l--) {
            curSum += grid[k][l];
        }
        if(sum!=curSum){
            return false;
        }

        return true;
    }
}