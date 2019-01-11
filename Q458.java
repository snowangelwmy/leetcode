/**
 * Test cases:
 * 1: Input: buckets=1, minutesToDie=1, minutesToTest=1
 * Output: 0
 * 2: Input: buckets=1000, minutesToDie=15, minutesToTest=60
 * Output: 5
 * 3: Input: buckets=4, minutesToDie=1, minutesToTest=1
 * Output: 2
 */

import java.lang.Math;

class Q458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int maxBuckets = (int)Math.pow(minutesToTest/minutesToDie +1, pigs);
        while(maxBuckets<buckets) {
            pigs++;
            maxBuckets = (int)Math.pow(minutesToTest/minutesToDie +1, pigs);
        }
        return pigs;
    }
}