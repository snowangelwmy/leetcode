/**
 * Test cases:
 * 1: Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 2: Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */

class Q72 {
    public int minDistance(String word1, String word2) {
        if(word1==null||word1.length()==0) {
            return word2==null||word2.length()==0 ? 0: word2.length();
        }

        if(word2==null||word2.length()==0) {
            return word1==null||word1.length()==0 ? 0: word1.length();
        }

        if(word1.equals(word2)) {
            return 0;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minDistances = new int[len1+1][len2+1];
        for(int i=1; i<=len2; i++) {
            minDistances[0][i] = i;
        }
        for(int i=1; i<=len1; i++) {
            minDistances[i][0] = i;
        }

        return minDistanceHelper(word1, word2, len1, len2, minDistances);
    }

    private int minDistanceHelper(String word1, String word2, int index1, int index2, int[][] minDistances) {
        if(index1==0&&index2==0) {
            return 0;
        }

        if(minDistances[index1][index2]!=0) {
            return minDistances[index1][index2];
        }

        if(word1.charAt(index1-1)==word2.charAt(index2-1)) {
            minDistances[index1][index2] = minDistanceHelper(word1, word2, index1-1, index2-1, minDistances);
            return minDistances[index1][index2];
        } else {
            minDistances[index1][index2] = getMin(
                    minDistanceHelper(word1, word2, index1-1, index2, minDistances),
                    minDistanceHelper(word1, word2, index1, index2-1, minDistances),
                    minDistanceHelper(word1, word2, index1-1, index2-1, minDistances)) + 1;
            return minDistances[index1][index2];
        }
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}