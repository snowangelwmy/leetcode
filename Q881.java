/**
 * Test cases:
 * 1: Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 * 2: Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 * 3: Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 */

import java.util.Arrays;

class Q881 {
    public int numRescueBoats(int[] people, int limit) {
        if(people==null||people.length==0) {
            return 0;
        }

        Arrays.sort(people);
        int low = 0;
        int high = people.length-1;
        int num = 0;
        while(low<high) {
            if(people[low]+people[high]<=limit) {
                num++;
                low++;
                high--;
            } else {
                num++;
                high--;
            }
        }

        if(low==high) {
            num++;
        }

        return num;
    }
}