/**
 * Test cases:
 * 1: Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 *
 * 2: Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 *
 * 3: Input: [1, 1, 1]
 * Output: True
 *
 * 4: Input: [1, 1]
 * Output: True
 */

import java.lang.Math;

class Q486 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums==null || nums.length <= 0) {
            return false;
        }

        int n = nums.length;
        int[][] scores = new int[n+1][n];
        for(int s=n-1; s>=0; s--) {
            scores[s][s] = nums[s];//if there is only 1 element, then player 1 wins.
            for(int e=s+1; e<n; e++) {//else if there are more than 1 elements, then apply the equation.
                scores[s][e] = Math.max(nums[s]-scores[s+1][e], nums[e]-scores[s][e-1]);
            }
        }

        return scores[0][n-1] >= 0;
    }
}