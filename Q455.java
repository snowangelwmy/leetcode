/**
 * Test cases:
 * 1: Input: [1,2,3], [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * 2: Input: [1,2], [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */

import java.util.Arrays;

class Q455 {
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||g.length==0||s==null||s.length==0){
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int pointerG = 0;
        int pointerS = 0;
        while(pointerG<g.length && pointerS<s.length) {
            if(g[pointerG]<=s[pointerS]){
                pointerG++;
                pointerS++;
            } else {//g[pointerG]>s[pointerS]
                pointerS++;
            }
        }

        return pointerG;
    }
}