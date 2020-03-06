/**
 * Test cases:
 * 1: Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 * 2: Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class TimeMap {

    private Map<String, List<Node>> map;

    class Node {
        String value;
        int timestamp;

        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, List<Node>>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Node>());
        }
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String value = "";
        if(!map.containsKey(key)) {
            return value;
        }

        List<Node> values = map.get(key);
        for(int i=values.size()-1; i>=0; i--) {
            if(values.get(i).timestamp<=timestamp) {
                return values.get(i).value;
            }
        }
        return value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */