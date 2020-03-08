/**
 * Test cases:
 * 1: Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * 2: Input: nums = [10, 5, 1, 6], k = 100
 * Output: 9
 * 3: Input: nums = [10, 5, 50], k = 100
 * Output: 4
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q713 {

    //https://leetcode.com/problems/subarray-product-less-than-k/solution/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums==null||nums.length==0||k<=1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int product = 1;
        for(int right=0; right<nums.length; right++) {
            product *= nums[right];
            while(product>=k) {
                product /= nums[left++];
            }
            ans += right-left+1;
        }

        return ans;
    }

    //Time Limit Exceeded
    class Subarray {
        int start;
        int end;

        public Subarray(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int numSubarrayProductLessThanK0(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        List<Subarray> maxSubarrays = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int product = 1;
            for(int j=i; j<nums.length; j++) {
                if(product*nums[j]>=k) {
                    if(j>i) {
                        if(maxSubarrays.size()==0||maxSubarrays.get(maxSubarrays.size()-1).end<j-1) {
                            maxSubarrays.add(new Subarray(i, j-1));
                        }
                    }
                    break;
                }
                if(j+1==nums.length) {
                    if(maxSubarrays.size()==0||maxSubarrays.get(maxSubarrays.size()-1).end<j) {
                        maxSubarrays.add(new Subarray(i, j));
                    }
                }
                product = product*nums[j];
            }
        }

        Set<String> allSubarrays = new HashSet<>();
        for(int i=0; i<maxSubarrays.size(); i++) {
            Subarray subarray = maxSubarrays.get(i);
            int start = subarray.start;
            int end = subarray.end;
            for(int n=1; n<=end-start+1; n++) {
                for(int j=start; j<=end-n+1; j++) {
                    allSubarrays.add(j+"_"+(j+n-1));
                }
            }
        }

        return allSubarrays.size();
    }
}