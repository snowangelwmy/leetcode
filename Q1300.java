/**
 * Test cases:
 * 1: Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 * 2: Input: arr = [2,3,5], target = 10
 * Output: 5
 * 3: Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 */

class Q1300 {

    //https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/discuss/464153/JAVA-Binary-Search
    public int findBestValue(int[] arr, int target) {
        if(arr==null||arr.length==0) {
            return -1;
        }

        int sum = 0;
        int high = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            high = Math.max(arr[i], high);
        }
        if(sum<=target) {
            return high;
        }

        int low = 0;
        int minDiff = Integer.MAX_VALUE;
        int value = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            int curSum = getSum(arr, mid);
            if(curSum==target) {
                return mid;
            } else if(curSum>target) {
                high = mid - 1;
            } else {//curSum<target
                low = mid + 1;
            }

            if(Math.abs(curSum-target)<minDiff||(Math.abs(curSum-target)==minDiff && mid < value)) {
                minDiff = Math.abs(curSum-target);
                value = mid;
            }
        }

        return value;
    }

    private int getSum(int[] arr, int value) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += (arr[i]>value) ? value : arr[i];
        }
        return sum;
    }
}