/**
 * Test cases:
 * 1: Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 2: Input: []
 * Output: []
 */

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Q406 {
    public class PeopleComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            int heightCompare = compareInt(b[0], a[0]);
            return heightCompare != 0 ? heightCompare : compareInt(a[1], b[1]);
        }

        private int compareInt(int a, int b) {
            return a > b ? 1 : (a < b ? -1 : 0);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if(people==null) {
            return null;
        }
        else if(people.length==0) {
            return new int[0][2];
        }

        Arrays.sort(people, new PeopleComparator());
        List<int[]> queue = new ArrayList(people.length);
        for(int i=0; i<people.length; i++) {
            queue.add(people[i][1], people[i]);
        }
        return queue.toArray(new int[people.length][2]);
    }
}