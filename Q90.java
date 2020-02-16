/**
 * Test cases:
 * 1: Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 2: Input: [1,1,2,2]
 * Output:
 * [
 *   [],
 *   [1],
 *   [1,1],
 *   [1,1,2],
 *   [1,1,2,2],
 *   [1,2],
 *   [1,2,2],
 *   [2],
 *   [2,2]
 * ]
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;
import java.util.Iterator;

class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return result;
        }

        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, result);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int index, List<List<Integer>> result) {
        if(index==nums.length) {
            List<Integer> empty = new ArrayList<>();
            result.add(empty);
            return;
        }

        int cur = nums[index];
        subsetsWithDupHelper(nums, index+1, result);
        List<List<Integer>> newSubsets = new ArrayList<>();
        for(List<Integer> subset : result) {
            List<Integer> newSubset = new ArrayList(subset);
            newSubset.add(0, cur);
            newSubsets.add(newSubset);
        }
        result.addAll(newSubsets);

        removeDup(result);
    }

    private void removeDup(List<List<Integer>> result) {
        Set<String> lookup = new HashSet<>();
        Iterator<List<Integer>> iterator = result.iterator();
        while(iterator.hasNext()) {
            String hashcode = getHashcode(iterator.next());
            if(lookup.contains(hashcode)) {
                System.out.println(hashcode);
                iterator.remove();
            } else {
                lookup.add(hashcode);
            }
        }
    }

    private String getHashcode(List<Integer> subset) {
        StringBuilder hashcode = new StringBuilder();
        for(int num : subset) {
            hashcode.append(num).append('_');
        }
        return hashcode.toString();
    }
}