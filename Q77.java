/**
 * Test cases:
 * 1: Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(n<=0) {
            return results;
        }
        else if(n<=k) {
            List<Integer> result = new ArrayList<>();
            for(int i=1; i<=n; i++) {
                result.add(i);
            }
            results.add(result);
            return results;
        }

        //n>k
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }
        combineHelper(results, nums, 0, k, new ArrayList<>());
        return results;
    }

    private void combineHelper(List<List<Integer>> results, int[] nums, int index, int k, List<Integer> result) {
        if(k==0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        for(int i=index; i<nums.length-k+1; i++) {
            result.add(nums[i]);
            combineHelper(results, nums, i+1, k-1, result);
            result.remove(result.size()-1);
        }
    }
}