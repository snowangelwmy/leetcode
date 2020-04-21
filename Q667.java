/**
 * Test cases:
 * 1: Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 * 2: Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * 3: Input: n = 6, k = 3
 * Output: [1, 2, 3, 6, 4, 5]
 * Explanation: The [1, 2, 3, 6, 4, 5] has six different positive integers ranging from 1 to 6, and the [1, 1, 3, 2, 1] has exactly 3 distinct integers: 1, 2 and 3.
 */

class Q667 {
    //https://leetcode.com/problems/beautiful-arrangement-ii/solution/
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int index = 0;
        for(int i=1; i<n-k; i++) {
            ans[index++] = i;
        }

        for(int i=0; i<=k; i++) {
            ans[index++] = i%2==0? (n-k+i/2) : (n-i/2);
        }

        return ans;
    }
}