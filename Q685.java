/**
 * Test cases:
 * 1: Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 *   1
 *  / \
 * v   v
 * 2-->3
 * 2: Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

class Q685 {
    public class OrbitResult {
        private int node;
        private Set<Integer> seen;

        public OrbitResult(int node, Set<Integer> seen) {
            this.node = node;
            this.seen = seen;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Integer> parents = new HashMap<>();//child-parent mapping
        List<int[]> candidate = new ArrayList<>();
        for(int i=0; i<edges.length; i++) {
            if(parents.containsKey(edges[i][1])) {//the node already has a parent
                candidate.add(new int[] {parents.get(edges[i][1]), edges[i][1]});
                candidate.add(edges[i]);
            } else {
                parents.put(edges[i][1], edges[i][0]);
            }
        }
        int root = traverseAlongParents(1, parents).node;
        if(candidate.isEmpty()) {//there must be a cycle
            Set<Integer> nodesInCycle = traverseAlongParents(root, parents).seen;
            int[] extraEdge = new int[2];
            for(int[] edge : edges) {
                if(nodesInCycle.contains(edge[0]) && nodesInCycle.contains(edge[1])) {
                    extraEdge = edge;
                }
            }
            return extraEdge;
        }

        //there is no cycle
        Map<Integer, List<Integer>> children = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : parents.entrySet()) {
            if(!children.containsKey(entry.getValue())) {
                children.put(entry.getValue(), new ArrayList<Integer>());
            }
            children.get(entry.getValue()).add(entry.getKey());
        }
        //dfs from root to check if every node is accessible.
        Stack<Integer> nodes = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        nodes.push(root);
        while(!nodes.isEmpty()) {
            int node = nodes.pop();
            if(!seen.contains(node)) {
                seen.add(node);
                if(children.containsKey(node)) {
                    for(int childNode : children.get(node)) {
                        nodes.push(childNode);
                    }
                }
            }
        }
        if(seen.size()==edges.length) {
            return candidate.get(1);
        } else {
            return candidate.get(0);
        }
    }

    private OrbitResult traverseAlongParents(int x, Map<Integer, Integer> parents) {
        Set<Integer> seen = new HashSet<>();
        while(parents.containsKey(x) && !seen.contains(x)){
            seen.add(x);
            x = parents.get(x);
        }
        return new OrbitResult(x, seen);
    }
}
