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

    //Disjoint Set Union (DSU)
    public class DSU {
        private int[] parents;
        private int[] ranks;

        public DSU(int size) {
            parents = new int[size];
            for(int i=0; i<parents.length; i++) {
                parents[i] = i;
            }
            ranks = new int[size];
        }

        //path compression
        public int find(int x) {
            if(parents[x]!=x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        //union-by-rank
        public boolean union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if(xParent==yParent) {
                return false;
            }
            if(ranks[xParent] < ranks[yParent]) {
                parents[xParent] = yParent;
            } else if(ranks[xParent] > ranks[yParent]) {
                parents[yParent] = xParent;
            } else {//ranks[xParent] = ranks[yParent]
                parents[yParent] = xParent;
                ranks[xParent]++;
            }
            return true;
        }
    }

    //Time Complexity: O(N), Space Complexity: O(N)
    public int[] findRedundantConnection2(int[][] edges) {
        DSU graph = new DSU(MAX_NODE_NUM+1);
        for(int i=0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            if(!graph.union(start, end)) {
                return new int[] {start, end};
            }
        }

        return null;
    }

    //Time Complexity: O(N^2), Space Complexity: O(N)
    public int[] findRedundantConnection1(int[][] edges) {
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