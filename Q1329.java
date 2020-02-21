/**
 * Test cases:
 * 1: Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 3, 3, 1, 1
 * 2, 2, 1, 2
 * 1, 1, 1, 2
 * Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 1, 1, 1, 1
 * 1, 2, 2, 2
 * 1, 2, 3, 3
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Q1329 {
    public int[][] diagonalSort(int[][] mat) {
        if(mat==null||mat.length==0||mat[0]==null||mat[0].length==0) {
            return mat;
        }

        int row = mat.length;
        int col = mat[0].length;

        int k=col-1;
        while(k>=0) {
            int i = 0;
            int j = k;

            List<Integer> nums = new ArrayList<>();
            while(i<row&&j<col) {
                nums.add(mat[i][j]);
                i++;
                j++;
            }
            Integer[] numsArray = new Integer[nums.size()];
            nums.toArray(numsArray);
            Arrays.sort(numsArray);
            int m = 0;
            i = 0;
            j = k;
            while(i<row&&j<col) {
                mat[i][j] = numsArray[m];
                i++;
                j++;
                m++;
            }
            k--;
        }

        k=1;
        while(k<row) {
            int i = k;
            int j = 0;

            List<Integer> nums = new ArrayList<>();
            while(i<row&&j<col) {
                nums.add(mat[i][j]);
                i++;
                j++;
            }
            Integer[] numsArray = new Integer[nums.size()];
            nums.toArray(numsArray);
            Arrays.sort(numsArray);
            int m = 0;
            i = k;
            j = 0;
            while(i<row&&j<col) {
                mat[i][j] = numsArray[m];
                i++;
                j++;
                m++;
            }

            k++;
        }
        return mat;
    }
}