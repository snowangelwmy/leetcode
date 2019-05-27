/**
 * Test cases:
 * 1: Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * 2: Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        result.add("JFK");
        if(tickets==null||tickets.size()==0) {
            return result;
        }

        // Sort the array in the lexiographincal order of location code
        Collections.sort(tickets, new Comparator<List<String>>(){
            @Override
            public int compare(List<String> t1, List<String> t2) {
                int result = t1.get(0).compareTo(t2.get(0));
                if(result==0) {
                    return t1.get(1).compareTo(t2.get(1));
                } else {
                    return result;
                }
            }
        });
        boolean[] visited = new boolean[tickets.size()];
        buildDfs(result, tickets, visited);
        return result;
    }

    private boolean buildDfs(List<String> result, List<List<String>> tickets, boolean[] visited) {
        if(result.size()==tickets.size()+1) { return true; }

        String origin = result.get(result.size()-1);
        for(int i=0; i<tickets.size(); i++) {
            if(!visited[i] && tickets.get(i).get(0).equals(origin)) {
                result.add(tickets.get(i).get(1));
                visited[i] = true;
                if(buildDfs(result, tickets, visited)) {
                    return true;
                } else {
                    result.remove(result.size()-1);
                    visited[i] = false;
                }
            }
        }
        return false;
    }
}