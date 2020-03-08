/**
 * Test cases:
 * 1: Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 * 2: Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 * 3: Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 */

class Q457 {
    //https://leetcode.com/problems/circular-array-loop/discuss/395670/JAVA-simple-DFS-O(n)-beat-100-time-and-space
    public boolean circularArrayLoop(int[] nums) {
        if(nums==null||nums.length<=1) {
            return false;
        }

        int[] visited = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(visited[i]==0 && hasCycle(nums, i, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(int[] nums, int start, int[] visited) {
        //searched before, and not found
        if(visited[start]==2) return false;
        if(visited[start]==1) return true;
        visited[start] = 1;
        int next = start + nums[start]%nums.length;
        if(next>=nums.length) {
            next = next%nums.length;
        } else if(next<0) {
            next = next+nums.length;
        }
        if(next==start||nums[start]*nums[next]<0) {
            visited[start] = 2;
            return false;
        }
        if(hasCycle(nums, next, visited)) {
            return true;
        }
        visited[start] = 2;
        return false;
    }
}
