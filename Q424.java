/**
 * Test cases:
 * 1: Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 2: Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 3: Input: s = "ABAA", k = 0
 * Output: 2
 * 4: Input: s = "ABBB", k = 2
 * Output: 4
 * 5: Input: s = "CABBABBB", k = 2
 * Output: 7
 */

class Q424 {
    public int characterReplacement(String s, int k) {
        if(s==null||s.length()==0) {
            return 0;
        }

        int maxLen = 1;
        int start = 0;
        while(start<s.length()) {
            int first = start;
            int second = start + 1;
            int changes = 0;
            char c = s.charAt(first);
            int next = -1;
            while(second<s.length()) {
                if(s.charAt(second)==c) {
                    second++;
                } else {
                    if(changes==0) {
                        next = second;
                    }
                    if(changes>=k) {
                        break;
                    }
                    changes++;
                    second++;
                }
            }
            while(changes<k&&first>0) {
                if(s.charAt(first)!=c) {
                    changes++;
                }
                if(s.charAt(first-1)==c||changes<k) {
                    first--;
                }
            }
            maxLen = Math.max(maxLen, second-first);
            start = next==-1 ? s.length() : next;
        }
        return maxLen;
    }
}