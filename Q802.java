import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Q802 {

    //https://leetcode.com/problems/find-eventual-safe-states/solution/
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> results = new ArrayList<>();
        if(graph==null||graph.length==0) {
            return results;
        }

        int[] visited = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!dfs(graph, i, visited)) {
                results.add(i);
            }
        }

        return results;
    }

    private boolean dfs(int[][] graph, int index, int[] visited) {
        if(visited[index] > 0) {
            return visited[index] == 1;
        }

        visited[index] = 1;
        int[] neighbors = graph[index];
        for(int neighbor : neighbors) {
            if(visited[neighbor]==2) {
                continue;
            }
            if(visited[neighbor]==1||dfs(graph, neighbor, visited)) {
                return true;
            }
        }
        visited[index] = 2;
        return false;
    }

    //Time Limit Exceeded
    public List<Integer> eventualSafeNodes0(int[][] graph) {
        List<Integer> results = new ArrayList<>();
        if(graph==null||graph.length==0) {
            return results;
        }

        boolean[] hasCycles = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            if(!dfs(graph, i, visited, hasCycles)) {
                results.add(i);
            } else {
                hasCycles[i] = true;
            }
        }

        return results;
    }

    private boolean dfs(int[][] graph, int index, Set<Integer> visited, boolean[] hasCycles) {
        if(hasCycles[index]) {
            return hasCycles[index];
        }

        if(graph[index].length==0) {
            return false;
        }

        int[] neighbors = graph[index];
        for(int neighbor : neighbors) {
            if(hasCycles[neighbor]||visited.contains(neighbor)) {
                return true;
            }
            visited.add(neighbor);
            if(dfs(graph, neighbor, visited, hasCycles)) {
                return true;
            }
            visited.remove(neighbor);
        }
        return false;
    }
}