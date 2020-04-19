/**
 * Test cases:
 * 1: Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 * 2: Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 3: Input: [1,2,3,4,4,5]
 * Output: False
 */

import java.util.Map;
import java.util.HashMap;

class Q659 {
    public boolean isPossible(int[] nums) {
        if(nums==null||nums.length<3) {
            return false;
        }

        Map<Integer, Integer> numCounts = new HashMap<>();
        Map<Integer, Integer> tailCounts = new HashMap<>();
        for(int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0)+1);
        }

        for(int num : nums) {
            if(numCounts.get(num)==0) {
                continue;
            }

            if(tailCounts.containsKey(num) && tailCounts.get(num)>0) {
                tailCounts.put(num, tailCounts.get(num)-1);
                tailCounts.put(num+1, tailCounts.getOrDefault(num+1, 0)+1);
            } else if(numCounts.containsKey(num+1) && numCounts.get(num+1)>0 && numCounts.containsKey(num+2) && numCounts.get(num+2)>0) {
                numCounts.put(num+1, numCounts.get(num+1)-1);
                numCounts.put(num+2, numCounts.get(num+2)-1);
                tailCounts.put(num+3, tailCounts.getOrDefault(num+3, 0)+1);
            } else {
                return false;
            }

            numCounts.put(num, numCounts.get(num)-1);
        }

        return true;
    }
}