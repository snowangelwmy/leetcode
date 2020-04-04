/**
 * Test cases:
 * 1: Input: A = "ab", B = "ba"
 * Output: true
 * 2: Input: A = "ab", B = "ab"
 * Output: false
 * 3: Input: A = "aa", B = "aa"
 * Output: true
 * 4: Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * 5: Input: A = "", B = "aa"
 * Output: false
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q859 {
    public boolean buddyStrings(String A, String B) {
        if(A==null||A.length()==0||B==null||B.length()==0||A.length()!=B.length()) {
            return false;
        }

        List<Integer> indexes = new ArrayList<>();
        Set<Character> lookup = new HashSet<>();
        boolean hasDupChars = false;
        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i)!=B.charAt(i)) {
                indexes.add(i);
            }
            if(lookup.contains(A.charAt(i))) {
                hasDupChars = true;
            } else {
                lookup.add(A.charAt(i));
            }
        }

        return (indexes.size()==2 && A.charAt(indexes.get(0)) == B.charAt(indexes.get(1)) && A.charAt(indexes.get(1)) == B.charAt(indexes.get(0))) || (indexes.size()==0 && hasDupChars);
    }
}