/**
 * Test cases:
 * 1: Input:
 *  matrix = [
 *    [1,2,3,4],
 *    [5,1,2,3],
 *    [9,5,1,2]
 *  ]
 * Output: True
 * Explanation: In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * 2: Input:
 *  matrix = [
 *    [1,2],
 *    [2,2]
 *  ]
 * Output: False
 * Explanation: In the above grid, the diagonals are:
 * "[2]", "[1, 2]", "[2]"
 * The diagonal "[1, 2]" has different elements, so the answer is False.
 */

import java.util.List;
import java.util.ArrayList;

class Q766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return true;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> elements = new ArrayList<>();
        elements.add(matrix[row-1][0]);
        int rowIdx = row-1;
        int colIdx = 0;
        while(!elements.isEmpty()) {
            List<Integer> nextElements = new ArrayList<>();
            int first = elements.get(0);
            addUpperElement(rowIdx, colIdx, nextElements, matrix);
            addRightElement(rowIdx, colIdx, nextElements, matrix);
            for(int i=1; i<elements.size(); i++) {
                if(elements.get(i)!=first) {
                    return false;
                }
                addRightElement(rowIdx+i, colIdx+i, nextElements, matrix);
            }
            elements = nextElements;
            rowIdx--;
            if(rowIdx==-1) {
                rowIdx=0;
                colIdx++;
            }
        }

        return true;
    }

    private void addUpperElement(int rowIdx, int colIdx, List<Integer> nextElements, int[][] matrix) {
        //upper element
        if(rowIdx-1>=0) {
            nextElements.add(matrix[rowIdx-1][colIdx]);
        }
    }

    private void addRightElement(int rowIdx, int colIdx, List<Integer> nextElements, int[][] matrix) {
        //right element
        if(colIdx+1<matrix[0].length) {
            nextElements.add(matrix[rowIdx][colIdx+1]);
        }
    }
}