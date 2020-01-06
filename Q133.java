/**
 * Test cases:
 * 1: Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * 1 -------- 2
 * |          |
 * |          |
 * |          |
 * 4 -------- 3
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {
        if(node==null) {
            return node;
        }

        Map<Node, Node> lookup = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        Node newNode = new Node(node.val, new ArrayList<Node>());
        lookup.put(node, newNode);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            //lookup.computeIfAbsent(cur, k -> new Node(k.val, new ArrayList<Node>()));
            if(cur.neighbors==null) {
                continue;
            }
            for(Node next : cur.neighbors) {
                lookup.computeIfAbsent(next, k -> new Node(k.val, new ArrayList<Node>()));
                Node newCur = lookup.get(cur);
                Node newNext = lookup.get(next);
                newCur.neighbors.add(newNext);
                if(!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return newNode;
    }
}