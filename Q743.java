/**
 * Test cases:
 * 1: Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 *
 * Output: 2
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Q743 {

    class Node {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        //You cannot use: Map<Integer, Integer>[] neighbors = new HashMap<Integer, Integer>[N]; here
        //as it is illegal to create a generic array.
        List<Map<Integer, Integer>> neighbors = new ArrayList<>(N);
        for(int i=0; i<N; i++) {
            neighbors.add(new HashMap<Integer, Integer>());
        }

        for(int i=0; i<times.length; i++) {
            int src = times[i][0]-1;
            int tgt = times[i][1]-1;
            int time = times[i][2];
            neighbors.get(src).put(tgt, time);
        }

        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(K-1, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(K-1, 0));
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            Map<Integer, Integer> nexts = neighbors.get(cur.id);
            for(Map.Entry<Integer, Integer> entry : nexts.entrySet()) {
                int nextId = entry.getKey();
                int nextDistance = cur.distance + entry.getValue();
                if(!distances.containsKey(nextId) || distances.get(nextId)>nextDistance) {
                    distances.put(nextId, nextDistance);
                    queue.offer(new Node(nextId, nextDistance));
                }
            }
        }

        if(distances.size()<N) {
            return -1;
        }

        int maxDistance = 0;
        for(Integer distance : distances.values()) {
            maxDistance = Math.max(maxDistance, distance);
        }

        return maxDistance;
    }
}