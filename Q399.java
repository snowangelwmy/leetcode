/**
 * Test cases:
 * 1: Input:
 *  equations = [ ["a", "b"], ["b", "c"] ],
 *  values = [2.0, 3.0],
 *  queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * Output: [6.0, 0.5, -1.0, 1.0, -1.0]
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Q399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> lookup = new HashMap<>();
        for(int i=0; i<equations.length; i++) {
            String[] equation = equations[i];
            if(!lookup.containsKey(equation[0])) {
                lookup.put(equation[0], new HashMap<String, Double>());
            }
            if(!lookup.containsKey(equation[1])) {
                lookup.put(equation[1], new HashMap<String, Double>());
            }
            lookup.get(equation[0]).put(equation[1], values[i]);
            lookup.get(equation[1]).put(equation[0], 1/values[i]);
        }

        double[] results = new double[queries.length];
        for(int i=0; i<queries.length; i++) {
            results[i] = dfs(queries[i][0], queries[i][1], lookup, new HashSet<>(), 1.0);
            if(results[i]==0.0) {
                results[i]=-1.0;
            }
        }
        return results;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> lookup, Set<String> seen, double value) {
        if(seen.contains(start)) {
            return 0.0;
        }
        if(!lookup.containsKey(start)) {
            return 0.0;
        }
        if(start.equals(end)) {
            return value;
        }
        seen.add(start);
        double result = 0.0;
        for(Map.Entry<String, Double> entry : lookup.get(start).entrySet()) {
            if(end.equals(entry.getKey())) {
                return entry.getValue() * value;
            }
            result = dfs(entry.getKey(), end, lookup, seen, entry.getValue() * value);
            if(result!=0.0) {
                return result;
            }
        }
        seen.remove(start);
        return result;
    }
}