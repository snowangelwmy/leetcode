/**
 * Test cases:
 * 1: Input: S = "heeellooo", words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 */

import java.util.List;
import java.util.ArrayList;

class Q809 {

    class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public int expressiveWords(String S, String[] words) {
        if(words==null||words.length==0) {
            return 0;
        }

        List<Node> groupCounts = getGroupCounts(S);
        int result = 0;
        for(String word : words) {
            List<Node> wordGroupCounts = getGroupCounts(word);
            if(isStretchy(groupCounts, wordGroupCounts)) {
                result++;
            }
        }

        return result;
    }

    private List<Node> getGroupCounts(String s) {
        List<Node> groupCounts = new ArrayList<>();
        if(s==null||s.length()==0) {
            return groupCounts;
        }

        char preC = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            char curC = s.charAt(i);
            if(curC==preC) {
                count++;
            } else {
                groupCounts.add(new Node(preC, count));
                preC = curC;
                count = 1;
            }
        }
        groupCounts.add(new Node(preC, count));
        return groupCounts;
    }

    private boolean isStretchy(List<Node> targetGroupCounts, List<Node> wordGroupCounts) {
        if(targetGroupCounts.size()!=wordGroupCounts.size()) {
            return false;
        }

        for(int i=0; i<targetGroupCounts.size(); i++) {
            Node targetNode = targetGroupCounts.get(i);
            Node wordNode = wordGroupCounts.get(i);
            if(targetNode.c!=wordNode.c||targetNode.count<wordNode.count||(targetNode.count>wordNode.count&&targetNode.count<3)) {
                return false;
            }
        }

        return true;
    }
}