/**
 * Test cases:
 * 1: Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 2: Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */

import java.util.List;
import java.util.ArrayList;

class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return ranges;
        }
        int start = 0;
        int end = 0;
        for(int i=1; i<=nums.length; i++) {
            if(i<nums.length&&nums[i]==nums[end]+1) {
                end++;
            } else {
                if(start==end) {
                    ranges.add(String.valueOf(nums[start]));
                } else {
                    ranges.add(nums[start]+"->"+nums[end]);
                }
                start=i;
                end=i;
            }
        }
        return ranges;
    }
}