/**
 * Test cases:
 * 1: Input: A = [[1,1,0],
 *                [0,1,0],
 *                [0,1,0]]
 *           B = [[0,0,0],
 *                [0,1,1],
 *                [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 */

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q835 {

    //Time Complexity: O(N^4), where N is the length of A or B.
    //Space Complexity: O(N^2).
    public int largestOverlap2(int[][] A, int[][] B) {
        if(A==null||A.length==0||A[0]==null||A[0].length==0||
                B==null||B.length==0||B[0]==null||B[0].length==0||
                A.length!=A[0].length||A.length!=B.length||B.length!=B[0].length||A[0].length!=B[0].length) {
            return 0;
        }

        int len = A.length;
        int[][] overlaps = new int[2*len][2*len];
        for(int ai=0; ai<len; ai++) {
            for(int aj=0; aj<len; aj++) {
                if(A[ai][aj]==1) {
                    for(int bi=0; bi<len; bi++) {
                        for(int bj=0; bj<len; bj++) {
                            if(B[bi][bj]==1) {
                                overlaps[bi-ai+len][bj-aj+len] += 1;
                            }
                        }
                    }
                }
            }
        }

        int largestOverlap = 0;
        for(int i=0; i<overlaps.length; i++) {
            for(int j=0; j<overlaps[0].length; j++) {
                largestOverlap = Math.max(largestOverlap, overlaps[i][j]);
            }
        }

        return largestOverlap;
    }

    //Time Complexity: O(N^6), where N is the length of A or B.
    //Space Complexity: O(N^2).
    public int largestOverlap1(int[][] A, int[][] B) {
        if(A==null||A.length==0||A[0]==null||A[0].length==0||
                B==null||B.length==0||B[0]==null||B[0].length==0||
                A.length!=A[0].length||A.length!=B.length||B.length!=B[0].length||A[0].length!=B[0].length) {
            return 0;
        }

        int len = A.length;
        List<Point> AA = new ArrayList<>(), BB = new ArrayList<>();
        for(int i=0; i<len*len; i++) {
            int x = i/len, y = i%len;
            if(A[x][y]==1) { AA.add(new Point(x, y)); }
            if(B[x][y]==1) { BB.add(new Point(x, y)); }
        }

        Set<Point> BSet = new HashSet<>(BB);
        Set<Point> seen = new HashSet<>();
        int largestOverlap = 0;
        for(Point a : AA) {
            for(Point b : BB) {
                Point delta = new Point(b.x-a.x, b.y-a.y);
                if(!seen.contains(delta)) {
                    seen.add(delta); //forgot this line of code will result in "Time Limit Exceeded" error
                    int overlap = 0;
                    for(Point aa : AA) {
                        if(BB.contains(new Point(aa.x+delta.x, aa.y+delta.y))) {
                            overlap++;
                        }
                    }
                    largestOverlap = Math.max(largestOverlap, overlap);
                }
            }
        }

        return largestOverlap;
    }
}
