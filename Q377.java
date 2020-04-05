/**
 * Test cases:
 * 1: nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * 2: Input: nums = [2, 1, 3], target = 35
 * Output: 1132436852
 */

import java.util.Map;
import java.util.HashMap;

class Q377 {

    public int combinationSum4(int[] nums, int target) {
        if(nums==null||nums.length==0||target<=0) {
            return 0;
        }

        Map<Integer, Integer> lookup = new HashMap<>();
        return combinationSum4Helper(nums, target, lookup);
    }

    private int combinationSum4Helper(int[] nums, int target, Map<Integer, Integer> lookup) {
        if(lookup.containsKey(target)) {
            return lookup.get(target);
        }

        if(0==target) {
            lookup.put(target, 1);
            return lookup.get(target);
        }

        int count = 0;
        for(int num : nums) {
            if(num<=target) {
                count += combinationSum4Helper(nums, target-num, lookup);
            }
        }
        lookup.put(target, count);
        return count;
    }

    //Time Limit Exceeded
    class Counter {
        int value;
    }

    public int combinationSum40(int[] nums, int target) {
        if(nums==null||nums.length==0||target<=0) {
            return 0;
        }

        Counter counter = new Counter();
        combinationSum4Helper(nums, 0, target, counter);
        return counter.value;
    }

    private void combinationSum4Helper(int[] nums, int sum, int target, Counter counter) {
        if(sum==target) {
            counter.value++;
            return;
        }

        for(int num : nums) {
            if(sum+num<=target) {
                combinationSum4Helper(nums, sum+num, target, counter);
            }
        }
    }
}