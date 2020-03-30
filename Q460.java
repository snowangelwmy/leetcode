/**
 * Test cases:
 * 1: LFUCache cache = new LFUCache(2);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4,4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 2: LFUCache cache = new LFUCache(0);
 * cache.put(0,0);
 * cache.get(0);       // returns -1 (not found)
 * 3: LFUCache cache = new LFUCache(3);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.put(3,3);
 * cache.put(4,4);     // evicts key 1
 * cache.get(4);       // returns 4
 * cache.get(3);       // returns 3
 * cache.get(2);       // returns 2
 * cache.get(1);       // returns -1
 * cache.put(5,5);     // evicts key 4
 * cache.get(1);       // returns -1
 * cache.get(2);       // returns 2
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns -1
 * cache.get(5);       // returns 5
 */

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class LFUCache {

    class Node {
        int key;
        int value;
        int count;
        long unixTime;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.unixTime = System.nanoTime();//you cannot use System.currentTimeMillis() here. why?
        }

        Node(int key, int value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.unixTime = System.nanoTime();
        }
    }

    int capacity;
    Map<Integer, Node> lookup;
    PriorityQueue<Node> queue;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lookup = new HashMap<Integer, Node>();
        this.queue = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                if(a.count!=b.count) {
                    return a.count - b.count;
                } else {//a.count==b.count
                    long diff = a.unixTime - b.unixTime;
                    if(diff>Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if(diff<Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    } else {
                        return (int) diff;
                    }
                }
            }
        });
    }

    public int get(int key) {
        Node node = this.lookup.get(key);
        if(node==null) {
            return -1;
        }
        Node newNode = new Node(key, node.value, node.count+1);
        queue.remove(node);
        queue.offer(newNode);
        this.lookup.put(key, newNode);
        return node.value;
    }

    public void put(int key, int value) {
        if(this.capacity<=0) {
            return;
        }
        Node node = this.lookup.get(key);
        if(node==null) {
            if(this.queue.size()==capacity) {
                Node evictNode = this.queue.poll();
                this.lookup.remove(evictNode.key);
            }
            Node newNode = new Node(key, value);
            queue.offer(newNode);
            this.lookup.put(key, newNode);
        } else {
            Node newNode = new Node(key, value, node.count+1);
            queue.remove(node);
            queue.offer(newNode);
            this.lookup.put(key, newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */