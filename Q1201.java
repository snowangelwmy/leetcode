/**
 * Test cases:
 * 1: Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * 2: Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * 3: Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 * 4: Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
 * Output: 1999999984
 */

class Q1201 {
    //https://leetcode.com/problems/ugly-number-iii/discuss/387587/Math-BinarySearch-Solution-(JAVA)
    public int nthUglyNumber(int n, int a, int b, int c) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        while(start < end) {
            int mid = start + (end-start)/2;
            int count = getUglyCount(mid, a, b, c);
            if(count < n) {
                start = mid + 1;
            } else {//count >= n
                end = mid;
            }
        }

        return end;
    }

    private int getUglyCount(int num, int a, int b, int c) {
        return (int)((num/a)+(num/b)+(num/c)-(num/lca(a,b))-(num/lca(b,c))-(num/lca(a,c))+(num/lca(a, lca(b,c))));
    }

    //this function needs to use long type, instead of int type
    private long lca(long a, long b) {
        return (a*b)/gcd(a, b);
    }

    private long gcd(long a, long b) {
        if(a==0) {
            return b;
        }

        return gcd(b%a, a);
    }
}