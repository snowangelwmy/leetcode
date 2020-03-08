/**
 * Test cases:
 * 1: Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * 2: Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * 3: Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * 4: Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * 5: Input: [0,1,6,6,4,4,6]
 * Output: 5
 * Explanation: We can collect [6,6,4,4,6].
 * If we started at the first tree or the eighth tree, we would only collect 5 fruits.
 */

import java.util.Set;
import java.util.HashSet;

class Q904 {
    public int totalFruit(int[] tree) {
        if(tree==null||tree.length==0) {
            return 0;
        }

        int maxTotal = 0;
        int start = 0;
        while(start<tree.length) {
            int total = 0;
            Set<Integer> baskets = new HashSet<>();
            for(int i=start; i<tree.length; i++) {
                if(baskets.contains(tree[i])) {
                    total++;
                } else if(baskets.size()<2) {
                    baskets.add(tree[i]);
                    total++;
                } else {//!baskets.contains(tree[i]) && baskets.size()==2
                    for(int j=i-1; j>=0; j--) {
                        if(tree[j]!=tree[i-1]) {
                            start = j+1;
                            break;
                        }
                    }
                    maxTotal = Math.max(maxTotal, total);
                    break;
                }

                if(i==tree.length-1) {
                    maxTotal = Math.max(maxTotal, total);
                    start = tree.length;
                }
            }
        }

        return maxTotal;
    }
}