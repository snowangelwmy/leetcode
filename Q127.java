/**
 * Test cases:
 * 1: Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 2: Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Q127 {

    private class Node {
        String word;
        int length;

        Node(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0||beginWord.equals(endWord)) {
            return 0;
        }

        Map<String, List<String>> lookup = new HashMap<>();
        for(String word : wordList) {
            for(int i=0; i<word.length(); i++) {
                String key = word.substring(0, i) + '*' + word.substring(i+1, word.length());
                lookup.computeIfAbsent(key, k -> new ArrayList<String>());
                lookup.get(key).add(word);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(beginWord, 1);
        queue.offer(node);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.word.equals(endWord)) {
                return current.length;
            }

            for(int i=0; i<current.word.length(); i++) {
                String key = current.word.substring(0, i) + '*' + current.word.substring(i+1, current.word.length());
                List<String> neighbors = lookup.getOrDefault(key, new ArrayList<String>());
                for(String neighbor : neighbors) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(new Node(neighbor, current.length+1));
                    }
                }
            }
        }

        return 0;
    }
}
