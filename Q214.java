/**
 * Test cases:
 * 1: Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 2: Input: "abcd"
 * Output: "dcbabcd"
 */

class Q214 {

    //https://leetcode.com/problems/shortest-palindrome/solution/
    //https://leetcode.com/problems/shortest-palindrome/discuss/467822/Java-KMP-O(N)-solution
    //KMP(Knuth–Morris–Pratt) algorithm
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<2) {
            return s;
        }

        String reversedS = new StringBuilder(s).reverse().toString();
        String newS = s + '#' + reversedS;
        int[] dp = new int[newS.length()];
        dp[0] = 0;
        for(int i=1; i<dp.length; i++) {
            int next = dp[i-1];
            while(next>0 && newS.charAt(i)!=newS.charAt(next)) {
                next = dp[next-1];
            }
            if(newS.charAt(i)==newS.charAt(next)) {
                next++;
            }
            dp[i] = next;
        }

        return reversedS.substring(0, s.length()-dp[newS.length()-1]) + s;
    }

    //Brute force: Time Limit Exceeded
    public String shortestPalindrome0(String s) {
        if(s==null||s.length()<2) {
            return s;
        }

        int count = 0;
        String newS = addChars(s, count);
        while(!isPalindrome(newS)) {
            count++;
            newS = addChars(s, count);
        }
        return newS;
    }

    private String addChars(String s, int count) {
        if(count==0) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<count; i++) {
            builder.append(s.charAt(s.length()-1-i));
        }
        builder.append(s);
        return builder.toString();
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        for(int i=0; i<length/2; i++) {
            if(s.charAt(i)!=s.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }
}