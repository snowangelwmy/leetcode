/**
 * Test cases:
 * 1: Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * 2: Input: [1, 2, 1, 2]
 * Output: False
 */

import java.util.List;
import java.util.ArrayList;

class Q679 {
    public boolean judgePoint24(int[] nums) {
        if(nums==null||nums.length==0) {
            return false;
        }
        List<Double> values = new ArrayList<>(nums.length);
        for(int num : nums) {
            values.add(Double.valueOf(num));
        }
        return solve(values);
    }

    private boolean solve(List<Double> nums) {
        if(nums.size()==1) {
            return Math.abs(nums.get(0)-24.0) < 1e-6;
        }
        for(int i=0; i<nums.size(); i++) {
            for(int j=0; j<nums.size(); j++) {
                if(i!=j) {
                    List<Double> nums2 = new ArrayList<>();
                    for(int k=0; k<nums.size(); k++) {
                        if(k!=i && k!=j) {
                            nums2.add(nums.get(k));
                        }
                    }
                    for(int k=0; k<4; k++) {
                        if(k<2 && j>i) continue;
                        if(k==0) nums2.add(nums.get(i)+nums.get(j));
                        else if(k==1) nums2.add(nums.get(i)*nums.get(j));
                        else if(k==2) nums2.add(nums.get(i)-nums.get(j));
                        else {
                            if(nums.get(j)!=0) {
                                nums2.add(nums.get(i)/nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if(solve(nums2)) return true;
                        nums2.remove(nums2.size()-1);
                    }
                }
            }
        }
        return false;
    }
}