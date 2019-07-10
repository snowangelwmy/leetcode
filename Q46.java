/**
 * Test cases:
 * 1: Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

import java.util.List;
import java.util.ArrayList;

class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return results;
        }

        permuteHelper(results, nums, new ArrayList<Integer>());
        return results;
    }

    private void permuteHelper(List<List<Integer>> results, int[] left, List<Integer> current) {
        if(left.length==0) {
            results.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i=0; i<left.length; i++) {
            current.add(left[i]);
            int[] newLeft = new int[left.length-1];
            int idx = 0;
            for(int j=0; j<left.length; j++) {
                if(j!=i) {
                    newLeft[idx++] = left[j];
                }
            }
            permuteHelper(results, newLeft, current);
            current.remove(current.size()-1);
        }
    }
}