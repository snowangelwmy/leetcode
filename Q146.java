/**
 * Test cases:
 * 1: Input && Output:
 * LRUCache cache = new LRUCache(2); //capacity
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);     // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);     // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

class LRUCache {
    //The laziest implementation using Java's LinkedHashMap
    private LinkedHashMap<Integer, Integer> data;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        data = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY; //cannot use this.CAPACITY, why?
            }
        };
    }

    public int get(int key) {
        return this.data.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.data.put(key, value);
    }

    //a "normal" HashMap + doubly-linked list implementation
    private final int CAPACITY;
    private Map<Integer, Node> lookup;
    private Node head, tail;
    private int count;

    public class Node {
        private int key, value;
        private Node previous;
        private Node next;
        public Node() {
            this.key = 0;
            this.value = 0;
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        lookup = new HashMap<Integer, Node>();
        count = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        Node node = lookup.get(key);
        if(node==null) {//instead of lookup.containsKey(key);
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node oldNode = lookup.get(key);
        if(oldNode!=null) {
            remove(oldNode);
            this.count--;
        }
        Node newNode = new Node(key, value);
        addToHead(newNode);
        lookup.put(key, newNode);
        this.count++;
        if(this.count > this.CAPACITY) {
            Node eldestNode = tail.previous;
            remove(eldestNode);
            lookup.remove(eldestNode.key);
            this.count--;
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }

    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
        node.previous = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */