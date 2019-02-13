/**
 * Test cases:
 * 1: Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * 2: Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q684 {
    private final static int MAX_NODE_NUM = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=MAX_NODE_NUM; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        Set<Integer> seen = new HashSet<>();
        for(int i=0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            seen.clear();
            if (!graph.get(start).isEmpty() && !graph.get(end).isEmpty() && dfs(start, end, graph, seen)) {
                return new int[] {start, end};
            }
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        return null;
    }

    private boolean dfs(int start, int end, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
        if(!seen.contains(start)) {
            seen.add(start);
            if(start==end) {
                return true;
            }
            for(int neighbor : graph.get(start)) {
                if(dfs(neighbor, end, graph, seen)) {
                    return true;
                }
            }
        }
        return false;
    }
}