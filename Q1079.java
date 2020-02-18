/**
 * Test cases:
 * 1: Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * 2: Input: "AAABBC"
 * Output: 188
 */

import java.util.Set;
import java.util.HashSet;

class Q1079 {
    public int numTilePossibilities(String tiles) {
        if(tiles==null||tiles.length()==0) {
            return 0;
        }

        Set<String> seqs = generateSeqs(tiles, 0);
        return seqs.size()-1;
    }

    private Set<String> generateSeqs(String tiles, int index) {
        if(index==tiles.length()) {
            Set<String> seqs = new HashSet<String>();
            seqs.add("");
            return seqs;
        }

        char c = tiles.charAt(index);
        Set<String> subSeqs = generateSeqs(tiles, index+1);
        Set<String> seqs = new HashSet<>(subSeqs);
        for(String s : subSeqs) {
            for(int i=0; i<=s.length(); i++) {
                StringBuilder builder = new StringBuilder(s);
                String newS = builder.insert(i, c).toString();
                if(!seqs.contains(newS)) {
                    seqs.add(newS);
                }
            }
        }
        return seqs;
    }
}