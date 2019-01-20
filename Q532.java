/**
 * Test cases:
 * 1: Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * 2: Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * 3: Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 */

import java.util.Set;
import java.util.HashSet;

class Q532 {
    public int findPairs(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        Set<String> pairs = new HashSet<>();
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(Math.abs(nums[i]-nums[j])==k) {
                    if(nums[i]<=nums[j]) {
                        pairs.add(nums[i]+","+nums[j]);
                    } else {
                        pairs.add(nums[j]+","+nums[i]);
                    }
                }
            }
        }
        return pairs.size();
    }
}