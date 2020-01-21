/**
 * Test cases:
 * 1: Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * 2: Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * 3: Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 * 4: Input: arr = [58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,68,71,20,22,48,74,2,65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35], start = 46
 * Output: false
 * Explanation: There is no way to reach at index 15 with value 0.
 */

import java.util.Queue;
import java.util.LinkedList;

class Q1306 {
    //https://leetcode.com/problems/jump-game-iii/discuss/485577/BFS-java-solution!
    public boolean canReach(int[] arr, int start) {
        if(arr==null||arr.length==0||start<0||start>=arr.length) {
            return false;
        }

        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int index = queue.poll();
            if(arr[index]==0) {
                return true;
            }

            if(index+arr[index]>=0 && index+arr[index]<n && !visited[index+arr[index]]) {
                visited[index+arr[index]] = true;
                queue.offer(index+arr[index]);
            }

            if(index-arr[index]>=0 && index-arr[index]<n && !visited[index-arr[index]]) {
                visited[index-arr[index]] = true;
                queue.offer(index-arr[index]);
            }
        }

        return false;
    }
}