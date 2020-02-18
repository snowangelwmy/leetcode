/**
 * Test cases:
 * 1: Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * 2: Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * 3: Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */

import java.util.HashSet;
import java.util.List;

class Q1239 {

    class ConcatenationResult {
        boolean canConcatenate;
        HashSet<Character> lookup;

        ConcatenationResult(boolean canConcatenate, HashSet<Character> lookup) {
            this.canConcatenate = canConcatenate;
            this.lookup = lookup;
        }
    }

    public int maxLength(List<String> arr) {
        if(arr==null||arr.size()==0) {
            return 0;
        }

        int maxLength = 0;
        for(int i=0; i<arr.size(); i++) {
            maxLength = Math.max(maxLength, getMaxLengthFrom(arr, i, new HashSet<Character>()));
        }
        return maxLength;
    }

    private int getMaxLengthFrom(List<String> arr, int index, HashSet<Character> lookup) {
        int maxLength = 0;

        ConcatenationResult cr1 = canConcatenate(lookup, arr.get(index));
        if(!cr1.canConcatenate) {
            return maxLength;
        }

        maxLength = arr.get(index).length();
        HashSet<Character> lookup1 = cr1.lookup;
        for(int i=index+1; i<arr.size(); i++) {
            maxLength = Math.max(maxLength, arr.get(index).length() + getMaxLengthFrom(arr, i, lookup1));
        }
        return maxLength;
    }

    private ConcatenationResult canConcatenate(HashSet<Character> lookup, String s) {
        ConcatenationResult cr = new ConcatenationResult(true, new HashSet<Character>(lookup));
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(cr.lookup.contains(c)) {
                cr.canConcatenate = false;
                break;
            } else {
                cr.lookup.add(c);
            }
        }

        return cr;
    }
}