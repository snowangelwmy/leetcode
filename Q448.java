/**
 * Test cases:
 * 1: Input: [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Q448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        if(nums==null||nums.length==0){
            return numbers;
        }
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -nums[index];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                numbers.add(i+1);
            }
        }

        return numbers;
    }
}