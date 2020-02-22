/**
 * Test cases:
 * 1: Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
 * 2: Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 */

import java.util.List;
import java.util.ArrayList;

class Q969 {

    class Pair {
        int min;
        int max;

        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();
        if(A==null||A.length<2) {
            return flips;
        }

        Pair pair = getFurthestReversedPair(A);
        while(pair!=null) {
            if(pair.min!=0) {
                flips.add(pair.min+1);
                reverse(A, 0, pair.min);
            }
            flips.add(pair.max+1);
            reverse(A, 0, pair.max);
            pair = getFurthestReversedPair(A);
        }
        return flips;
    }

    private Pair getFurthestReversedPair(int[] A) {
        for(int i=0; i<A.length-1; i++) {
            for(int j=A.length-1; j>i; j--) {
                if(A[i]>A[j]) {
                    return new Pair(i, j);
                }
            }
        }

        return null;
    }

    private void reverse(int[] A, int start, int end) {
        int i = start;
        int j = end;
        while(i<j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}