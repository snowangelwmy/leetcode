/**
 * Test cases:
 * 1: Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3,
 * Output: [1,2,2,3,5,6]
 */

class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1;
        int idx2 = n-1;
        int idx = m+n-1;
        while(idx1>=0 && idx2>=0) {
            if(nums1[idx1]>nums2[idx2]){
                nums1[idx] = nums1[idx1];
                idx1--;
            } else { //nums1[idx1]<=nums2[idx2]
                nums1[idx] = nums2[idx2];
                idx2--;
            }
            idx--;
        }
        while(idx2>=0){
            nums1[idx] = nums2[idx2];
            idx2--;
            idx--;
        }
    }
}