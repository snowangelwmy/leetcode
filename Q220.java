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
 */

class Q220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
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