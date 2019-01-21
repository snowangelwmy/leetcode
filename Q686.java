/**
 * Test cases:
 * 1: Input: A = "abcd" and B = "cdabcdab"
 * Output: 3
 * Explanation: By repeating A three times (“abcdabcdabcd”), B is a substring of it;
 * and B is not a substring of A repeated two times ("abcdabcd").
 */

class Q686 {
    public int repeatedStringMatch(String A, String B) {
        if(A==null||B==null) {
            return -1;
        }
        int num = 1;
        StringBuilder builder = new StringBuilder(A);
        while(builder.length()<B.length()) {
            num++;
            builder.append(A);
        }
        if(builder.toString().contains(B)) {
            return num;
        }
        if(builder.append(A).toString().contains(B)) {
            return num+1;
        }
        return -1;
    }
}