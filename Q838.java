/**
 * Test cases:
 * 1: Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * 2: Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 */

import java.util.List;
import java.util.ArrayList;

class Q838 {

    private static final char LEFT = 'L';

    private static final char RIGHT = 'R';

    private static final char DOT = '.';

    //https://leetcode.com/problems/push-dominoes/solution/
    public String pushDominoes(String dominoes) {
        if(dominoes==null||dominoes.length()==0) {
            return dominoes;
        }

        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        List<Character> symbols = new ArrayList<>();
        symbols.add(LEFT);
        for(int i=0; i<dominoes.length(); i++) {
            if(dominoes.charAt(i)!=DOT) {
                indexes.add(i+1);
                symbols.add(dominoes.charAt(i));
            }
        }
        indexes.add(dominoes.length());
        symbols.add(RIGHT);

        char[] ans = dominoes.toCharArray();
        for(int i=1; i<indexes.size(); i++) {
            int startIndex = indexes.get(i-1);
            int endIndex = indexes.get(i);
            char start = symbols.get(i-1);
            char end = symbols.get(i);
            if(start==end) {
                for(int j=startIndex; j<endIndex; j++) {
                    ans[j] = start;
                }
            } else if(start==RIGHT&&end==LEFT) {
                for(int j=startIndex; j<endIndex; j++) {
                    if(j+1-startIndex<endIndex-j-1) {
                        ans[j] = RIGHT;
                    } else if(j+1-startIndex>endIndex-j-1) {
                        ans[j] = LEFT;
                    }
                }
            }
        }

        return new String(ans);
    }
}