/**
 * Test cases:
 * 1: Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * 2: Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation:
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * 3: Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 */

class Q1011 {
    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/521941/Java-Binary-Search-solution-and-complexity-calculation-with-explaination
    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0;
        int maxWeight = 0;
        for(int i=0; i<weights.length; i++) {
            totalWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int low = maxWeight;
        int high = totalWeight;
        while(low<high) {
            int mid = (low+high)/2;
            if(possible(weights, mid, D)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] weights, int size, int D) {
        int shipNum = 1;
        int total = 0;
        for(int weight : weights) {
            if(size>=total+weight) {
                total += weight;
            } else {
                shipNum++;
                total = weight;
                if(shipNum>D) {
                    return false;
                }
            }
        }
        return true;
    }
}