/**
 * Test cases:
 * 1: Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 2: Input: nums = [1], k = 1
 * Output: [1]
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Q347 {

    class Node {
        int value;
        int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return result;
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for(int num : nums) {
            if(!frequency.containsKey(num)) {
                frequency.put(num, 0);
            }
            frequency.put(num, frequency.get(num)+1);
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);

        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            heap.add(node);
            if(heap.size()>k) {
                heap.poll();
            }
        }

        while(!heap.isEmpty()) {
            result.add(heap.poll().value);
        }
        //Collections.sort(result, Collections.reverseOrder()); //why this one doesn't work?
        Collections.reverse(result);
        return result;
    }
}