/**
 * Test cases:
 * 1: Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * 2: Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 * 3: Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 * 4: Input: s = "QQQQ"
 * Output: 3
 * Explanation: We can replace the last 3 'Q' to make s = "QWER".
 * 5: Input: s = "WWEQERQWQWWRWWERQWEQ"
 * Output: 4
 * Explanation: We can replace the "WQWW" to "EQRR".
 */

class Q1234 {

    private static final char A = 'A';

    private static final char[] CHARS = {'Q', 'W', 'E', 'R'};

    //https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC++Python-Sliding-Window
    public int balancedString(String s) {
        if(s==null||s.length()==0||s.length()%4!=0) {
            return -1;
        }

        int[] counts = new int[26];
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i) - A;
            counts[index]++;
        }

        int threshold = s.length()/4;

        if(counts[CHARS[0]-A]<=threshold && counts[CHARS[1]-A]<=threshold &&
                counts[CHARS[2]-A]<=threshold && counts[CHARS[3]-A]<=threshold) {
            return 0;
        }

        int replaces = s.length();
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            counts[s.charAt(right)-A]--;
            while(counts[CHARS[0]-A]<=threshold && counts[CHARS[1]-A]<=threshold &&
                    counts[CHARS[2]-A]<=threshold && counts[CHARS[3]-A]<=threshold) {
                replaces = Math.min(replaces, right-left+1);
                counts[s.charAt(left++)-A]++;
            }
        }
        return replaces;
    }
}