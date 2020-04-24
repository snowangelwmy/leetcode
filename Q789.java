/**
 * Test cases:
 * 1: Input: ghosts = [[1, 0], [0, 3]], target = [0, 1]
 * Output: true
 * Explanation: You can directly reach the destination (0, 1) at time 1, while the ghosts located at (1, 0) or (0, 3) have no way to catch up with you.
 * 2: Input: ghosts = [[1, 0]], target = [2, 0]
 * Output: false
 * Explanation: You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.
 * 3: Input: ghosts = [[2, 0]], target = [1, 0]
 * Output: false
 * Explanation: The ghost can reach the target at the same time as you.
 */

class Q789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        if(target==null||target.length<2) {
            return false;
        }

        int[] start = {0, 0};
        int step = distance(start, target);
        if(ghosts==null||ghosts.length==0) {
            return true;
        }

        for(int[] ghost : ghosts) {
            if(ghost==null||ghost.length<2) {
                continue;
            }

            int ghostStep = distance(ghost, target);
            if(ghostStep<=step) {
                return false;
            }
        }

        return true;
    }

    private int distance(int[] start, int[] target) {
        return Math.abs(target[0]-start[0]) + Math.abs(target[1]-start[1]);
    }
}