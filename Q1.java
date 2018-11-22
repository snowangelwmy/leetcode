import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        indices[0] = -1;
        indices[1] = -1;

        if(nums==null||nums.length<=0){
            return indices;
        }

        Map<Integer, List<Integer>> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer key = new Integer(nums[i]);
            if(!lookup.containsKey(key)) {
                lookup.put(key, new ArrayList());
            }

            lookup.get(key).add(new Integer(i));
        }

        for(int i=0; i<nums.length; i++){
            Integer diff = new Integer(target-nums[i]);
            if(diff==nums[i]){
                if(lookup.get(diff).size()>1){
                    indices[0] = lookup.get(diff).get(0);
                    indices[1] = lookup.get(diff).get(1);
                }
            } else {
                if(lookup.containsKey(diff)) {
                    indices[0] = i;
                    indices[1] = lookup.get(diff).get(0);
                    return indices;
                }
            }
        }

        return indices;
    }
}