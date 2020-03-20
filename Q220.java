/**
 * Test cases:
 * 1: Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 2: Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 3: Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 4: Input: nums = [-1,2147483647], k = 1, t = 2147483647
 * Output: false
 * 5: Input: nums = [0,2147483647], k = 1, t = 2147483647
 * Output: true
 * 6: Input: nums = [1,2], k = 0, t = 1
 * Output: false
 */

import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

class Q220 {

    //Slide window
    //https://leetcode.com/problems/contains-duplicate-iii/discuss/508393/JAVA-EASY-Solution-with-EXPLANATION
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        TreeSet<Long> window = new TreeSet<>();
        int left = 0;
        for(int right=0; right<nums.length; right++) {
            Long min = window.ceiling(Long.valueOf(nums[right])-t);
            if(min!=null && min<=nums[right]) {
                return true;
            }

            Long max = window.floor(Long.valueOf(nums[right])+t);
            if(max!=null && max>=nums[right]) {
                return true;
            }

            window.add(Long.valueOf(nums[right]));

            if(right-left>=k) {
                window.remove(Long.valueOf(nums[left++]));
            }
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length && j<=i+k; j++) {
                long numI = nums[i];
                long numJ = nums[j];
                long I = i;
                long J = j;
                if(Math.abs(numI-numJ)<=t && Math.abs(I-J)<=k) {
                    return true;
                }
            }
        }

        return false;
    }

    //Slide window, Time Limit Exceeded
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        int left = 0;
        for(int right=1; right<nums.length; right++) {
            while(right-left>k) {
                left++;
            }

            //right-left<=k
            int index = left;
            while(index<right) {//distinct indexes
                Long numRight = Long.valueOf(nums[right]);
                Long numIndex = Long.valueOf(nums[index]);
                if(Math.abs(numRight-numIndex)<=t) {
                    return true;
                }
                index++;
            }
        }

        return false;
    }

    // Time Limit Exceeded
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        Map<Long, Integer> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            Long numI = Long.valueOf(nums[i]);
            int j = 0;
            while(j<=t) {
                if(lookup.containsKey(numI-j) && i-lookup.get(numI-j)<=k) {
                    return true;
                }
                if(lookup.containsKey(numI+j) && i-lookup.get(numI+j)<=k) {
                    return true;
                }
                j++;
            }
            lookup.put(numI, i);
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        if(nums==null||nums.length<2) {
            return false;
        }

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                long numI = nums[i];
                long numJ = nums[j];
                long I = i;
                long J = j;
                if(Math.abs(numI-numJ)<=t && Math.abs(I-J)<=k) {
                    return true;
                }
            }
        }

        return false;
    }
}