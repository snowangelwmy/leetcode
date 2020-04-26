/**
 * Test cases:
 * 1: Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * 2: Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */

class Q832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A==null||A.length==0||A[0]==null||A[0].length==0) {
            return null;
        }

        int[][] newA = new int[A.length][A[0].length];
        //flip the image horizontally
        for(int i=0; i<A.length; i++) {
            for(int j=A[0].length-1; j>=0; j--) {
                newA[i][A[0].length-1-j] = A[i][j];
            }
        }

        //invert an image
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                newA[i][j] = newA[i][j]==0 ? 1 : 0;
            }
        }

        return newA;
    }
}