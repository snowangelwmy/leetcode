/**
 * Test cases:
 * 1: Input: 2.00000, 10
 * Output: 1024.00000
 * 2: Input: 2.10000, 3
 * Output: 9.26100
 * 3: Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 4: Input: 0.00001, 2147483647
 * Output: 0.0
 * 5: Input: 1.00000, -2147483648
 * Output: 1.0
 * Notes: -(-2147483648) = -2147483648 as the minimum value of int is -2,147,483,648 while the maximum value of int is only 2,147,483,647.
 */

import java.util.Map;
import java.util.HashMap;

class Q50 {

    //https://leetcode.com/problems/powx-n/discuss/513694/Java-100-faster-by-recursion-(Easy-Solution)
    public double myPow(double x, int n) {
        if(n<0) {
            return myPowHelper(1/x, n);
        }

        return myPowHelper(x, n);
    }

    private double myPowHelper(double x, int n) {
        if(n==0) {
            return 1.0;
        }
        if(n==1) {
            return x;
        }

        double part = myPowHelper(x, n/2);

        if(n%2==0) {
            return part * part;
        } else {
            return part * part * x;
        }
    }

    //Approach 1: Time Limit Exceeded
    public double myPow0(double x, int n) {
        if(n==0) {
            return 1.0;
        }
        if(n<0) {
            return 1/myPow0(x, -n);
        }

        //n>0
        Map<Integer, Double> lookup = new HashMap<>();
        return myPow(x, n, lookup);
    }

    private double myPow(double x, int n, Map<Integer, Double> lookup) {
        if(lookup.containsKey(n)) {
            return lookup.get(n);
        }

        if(n==1) {
            lookup.put(1, x);
            return lookup.get(1);
        }

        if(n%2==0) {
            return myPow(x, n/2, lookup) * myPow(x, n/2, lookup);
        } else {
            return myPow(x, n/2, lookup) * myPow(x, (n+1)/2, lookup);
        }
    }
}