/**
 * Test cases:
 * 1: Input: 4, Output: 2
 * 2: Input: 8, Output: 2
 * 3: Input: 0, Output: 0
 * 4: Input: 2147395599, Output: 46339
 */

import java.lang.Math;

class Solution {
    public int mySqrt(int x) {
        if(x<0){
            return -1;
        }

        int low = 0;
        int high = x;
        while(low<=high){
            int mid = (low+high)/2;
            if(Math.pow(mid,2) <= x && x <Math.pow(mid+1,2)){
                return mid;
            } else if(Math.pow(mid,2) > x) {
                high = mid-1;
            } else {//x >= Math.pow(mid+1,2)
                low = mid+1;
            }
        }

        return -1;
    }
}