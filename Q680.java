/**
 * Test cases:
 * 1: Input: "aba"
 * Output: True
 * 2: Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 3: Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */

class Q680 {

    //https://leetcode.com/problems/valid-palindrome-ii/discuss/493705/Java-Iterative-Solution-in-O(n)-time-or-Easy-to-read
    public boolean validPalindrome(String s) {
        if(s==null) {
            return false;
        }
        if(s.length()==0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while(left<right) {
            if(s.charAt(left)!=s.charAt(right)) {
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    //Time Limit Exceeded
    public boolean validPalindrome0(String s) {
        if(s==null) {
            return false;
        }
        if(s.length()==0) {
            return true;
        }

        if(isPalindrome(s)) {
            return true;
        }

        for(int i=0; i<s.length(); i++) {
            String newS = s.substring(0, i) + s.substring(i+1);
            if(isPalindrome(newS)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while(low<high) {
            if(s.charAt(low)!=s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
