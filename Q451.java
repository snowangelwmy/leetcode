/**
 * Test cases:
 * 1: Input: "tree"
 * Output: "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 2: Input: "cccaaa"
 * Output: "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 3: Input: "Aabb"
 * Output: "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class Q451 {

    class Node {
        char value;
        int count;

        public Node(char value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        if(s==null||s.length()==0) {
            return s;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n2.count-n1.count);
        for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            queue.offer(node);
        }

        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            char c = node.value;
            int count = node.count;
            for(int i=0; i<count; i++) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}