/**
 * Test cases:
 * 1: Input: x = 3, y = 5, z = 4
 * Output: True
 * 2: Input: x = 2, y = 6, z = 5
 * Output: False
 */

class Q365 {
    //https://www.cnblogs.com/grandyang/p/5628836.html
    //https://leetcode.com/problems/water-and-jug-problem/discuss/450212/Java-:-Using-GCD.-O(LOG(XY))-Runtime-and-Memory.
    //https://blog.csdn.net/lanchunhui/article/details/50594649
    public boolean canMeasureWater(int x, int y, int z) {
        if(z==0) {
            return true;
        }

        return (x+y>=z && (z%gcd(x,y)==0));
    }

    private int gcd(int x, int y) {
        return y==0? x : gcd(y, x%y);
    }
}