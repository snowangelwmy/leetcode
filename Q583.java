import java.util.Arrays;

class Q583 {

    //https://leetcode.com/problems/delete-operation-for-two-strings/solution/
    public int minDistance(String word1, String word2) {
        if(word1==null&&word2==null) {
            return 0;
        }

        if(word1==null) {
            return word2.length();
        }

        if(word2==null) {
            return word1.length();
        }

        int[][] lookup = new int[word1.length()+1][word2.length()+1];
        for(int[] item : lookup) {
            Arrays.fill(item, -1);
        }
        return minDistanceHelper(word1, 0, word2, 0, lookup);
    }

    private int minDistanceHelper(String word1, int i, String word2, int j, int[][] lookup) {
        if(lookup[i][j]!=-1) {
            return lookup[i][j];
        }

        if(i==word1.length()) {
            lookup[i][j] = word2.length()-j;
            return lookup[i][j];
        }

        if(j==word2.length()) {
            lookup[i][j] = word1.length()-i;
            return lookup[i][j];
        }

        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        if(c1==c2) {
            lookup[i][j] = minDistanceHelper(word1, i+1, word2, j+1, lookup);
        } else {
            lookup[i][j] = Math.min(minDistanceHelper(word1, i, word2, j+1, lookup), minDistanceHelper(word1, i+1, word2, j, lookup)) + 1;
        }
        return lookup[i][j];
    }


    //Time Limit Exceeded
    public int minDistance0(String word1, String word2) {
        if(word1==null&&word2==null) {
            return 0;
        }

        if(word1==null) {
            return word2.length();
        }

        if(word2==null) {
            return word1.length();
        }

        return minDistanceHelper(word1, 0, word2, 0);
    }

    private int minDistanceHelper(String word1, int i, String word2, int j) {
        if(i==word1.length()) {
            return word2.length()-j;
        }

        if(j==word2.length()) {
            return word1.length()-i;
        }

        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        if(c1==c2) {
            return minDistanceHelper(word1, i+1, word2, j+1);
        } else {
            return Math.min(minDistanceHelper(word1, i, word2, j+1), minDistanceHelper(word1, i+1, word2, j)) + 1;
        }
    }
}