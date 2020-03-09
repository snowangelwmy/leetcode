/**
 * Test cases:
 * 1: Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * 2: Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * 3: Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 * 4: Input: nums = [0,1,1,2,1,2,1], k = 3
 * Output: 5
 * 5: Input: nums = [1,1,1,1,1], k = 1
 * Output: 5
 */

import java.util.Map;
import java.util.HashMap;

class Q1248 {

    //sliding window solution
    //https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC++Python-Sliding-Window-O(1)-Space
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int count = 0;
        for(int right = 0; right<nums.length; right++) {
            if(nums[right]%2==1) {
                k--;
                count = 0;
            }

            while(k==0) {
                count++;
                k += (nums[left++] & 1);
            }
            result += count;
        }

        return result;
    }

    //PrefixSum solution
    //https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419502/Java-PrefixSum-1pass-10line-7ms
    public int numberOfSubarrays1(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int[] prefixOdds = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            prefixOdds[i+1] += prefixOdds[i];
            prefixOdds[i+1] += nums[i]%2==0? 0: 1;
        }

        int count = 0;
        //a (key, value) pair in the lookup map represents
        // the number of subarrays (value) starting from 0 with key odd numbers
        Map<Integer, Integer> lookup = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(prefixOdds[i+1]==k) {
                count++;
            }
            lookup.put(prefixOdds[i+1], lookup.getOrDefault(prefixOdds[i+1], 0)+1);
            count += lookup.getOrDefault(prefixOdds[i+1]-k, 0);
        }

        return count;
    }

    public int numberOfSubarrays0(int[] nums, int k) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int[] prefixOdds = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            prefixOdds[i+1] += prefixOdds[i];
            prefixOdds[i+1] += nums[i]%2==0? 0: 1;
        }

        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(prefixOdds[i+1]<k) {
                continue;
            } else if(prefixOdds[i+1]==k) {
                count++;
            }

            for(int j=0; j<i; j++) {
                if(prefixOdds[i+1]-prefixOdds[j+1]==k) {
                    count++;
                } else if(prefixOdds[i+1]-prefixOdds[j+1]>k) {
                    continue;
                } else {//prefixOdds[i+1]-prefixOdds[j+1]<k
                    break;
                }
            }
        }

        return count;
    }
}