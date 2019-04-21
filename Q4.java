/**
 * Test cases:
 * 1: nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 2: nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */

class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) {
            //swap nums1 <=> nums2 and m <=> n to make sure m is always <= n
            int[] tempNums = nums1; nums1 = nums2; nums2 = tempNums;
            int tempLen = m; m = n; n = tempLen;
        }
        int iMin = 0; int iMax = m; int halfLen = (m+n+1)/2;
        while(iMin<=iMax) {
            int i = (iMin+iMax)/2;
            int j = halfLen - i;
            if(i>iMin && nums1[i-1]>nums2[j]) { //i>0 => j<m
                iMax = i-1; //i is too big
            } else if(i<iMax && nums2[j-1]>nums1[i]) { //i<m => j>0
                iMin = i+1; //i is too small
            } else { //i is prefect
                int maxLeft = 0;
                if(i==0) {
                    maxLeft = nums2[j-1];
                } else if(j==0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if((m+n)%2==1) {//odd
                    return maxLeft;
                }
                int minRight = 0;
                if(i==m) {
                    minRight = nums2[j];
                } else if(j==n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }
}