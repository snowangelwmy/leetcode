/**
 * Test cases:
 * 1: Input: [2,2,1]
 * Output: 1
 * 2: Input: [4,1,2,1,2]
 * Output: 4
 */

import java.util.Map;
import java.util.HashMap;

class Q136 {

    public int singleNumber2(int[] nums) {
        if(nums==null||nums.length==0){
            return Integer.MIN_VALUE;
        }

        int num = 0;
        for(int i=0; i<nums.length; i++){
            num = num ^ nums[i];
        }

        return num;
    }

    //using extra memory
    public int singleNumber1(int[] nums) {
        if(nums==null||nums.length==0){
            return Integer.MIN_VALUE;
        }

        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(lookup.containsKey(nums[i])){
                lookup.remove(nums[i]);
            } else {
                lookup.put(nums[i], 1);
            }
        }

        if(lookup.size()==1){
            for(Integer key : lookup.keySet()){
                return key;
            }
        }

        return Integer.MIN_VALUE;
    }
}