/**
 * Test cases:
 * 1: Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 */

import java.util.Arrays;

class Q853 {

    //https://leetcode.com/problems/car-fleet/solution/
    class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if(position==null||position.length==0||speed==null||speed.length==0) {
            return 0;
        }

        int num = Math.min(position.length, speed.length);
        Car[] cars = new Car[num];
        for(int i=0; i<num; i++) {
            cars[i] = new Car(position[i], (double)(target-position[i])/speed[i]);
        }
        Arrays.sort(cars, (a, b) -> a.position-b.position);

        int ans = 0;
        for(int i=num-1; i>=1; i--) {
            if(cars[i].time<cars[i-1].time) {
                ans++;
            } else {//cars[i].time>=cars[i-1].time
                cars[i-1] = cars[i];
            }
        }
        return ans+1;
    }
}