/**
 * Test cases:
 * 1: Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * 2: Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms==null||rooms.size()<2) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while(!queue.isEmpty()) {
            int room = queue.poll();
            if(room>=0&&room<rooms.size()) {
                List<Integer> nextRooms = rooms.get(room);
                for(Integer nextRoom : nextRooms) {
                    if(!visited.contains(nextRoom)) {
                        queue.offer(nextRoom);
                        visited.add(nextRoom);
                    }
                }
            }
        }
        return visited.size() == rooms.size();
    }
}