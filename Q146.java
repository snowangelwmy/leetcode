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

class LRUCache {
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
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */