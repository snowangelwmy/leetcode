/**
 * Test cases:
 * 1: Input: n = 3, k = 3
 * Output: "213"
 * 2: Input: n = 4, k = 9
 * Output: "2314"
 */

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuffer;

class Q60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList(n);
        for(int i=1; i<=n; i++) {
            nums.add(i);
        }

        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i=1; i<n; i++) {
            factorial[i] = i*factorial[i-1];
        }

        k--;
        StringBuffer sb = new StringBuffer();
        for(int i=n-1; i>=0; i--) {
            int index = k/factorial[i];
            sb.append(nums.get(index));
            nums.remove(index);
            k=k%factorial[i];
        }
        return sb.toString();
    }
}