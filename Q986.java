/**
 * Test cases:
 * 1: Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 * 2: Input: A = [], B = []
 * Output: []
 * 3: Input: A = [[1,7]], B = [[3,10]]
 * Output: [[3,7]]
 */

import java.util.List;
import java.util.ArrayList;

class Q986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A==null||A.length==0||B==null||B.length==0) {
            int[][] empty = {};
            return empty;
        }

        List<int[]> intersections = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<A.length && j<B.length) {
            int[] curA = A[i];
            int[] curB = B[j];
            if(curA[0]<=curB[0]) {
                if(curB[0]<=curA[1]) {
                    if(curA[1]<=curB[1]) {
                        intersections.add(new int[]{curB[0], curA[1]});
                        i++;
                    } else { //curB[1]<curA[1]
                        intersections.add(new int[]{curB[0], curB[1]});
                        j++;
                    }
                } else {//curA[1]<curB[0]
                    i++;
                }
            } else {//curB[0]<curA[0]
                if(curA[0]<=curB[1]) {
                    if(curB[1]<=curA[1]) {
                        intersections.add(new int[]{curA[0], curB[1]});
                        j++;
                    } else {//curA[1]<curB[1]
                        intersections.add(new int[]{curA[0], curA[1]});
                        i++;
                    }
                } else {//curB[1]<curA[0]
                    j++;
                }
            }
        }

        int[][] result = intersections.toArray(new int[0][2]);
        return result;
    }
}