/**
 * Test cases:
 * 1: Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * 2: Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 */

class Q785 {
    public boolean isBipartite(int[][] graph) {
        if(graph==null||graph.length==0) {
            return false;
        }

        int[] colors = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(colors[i]==0 && !isValidColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColor(int[][] graph, int[] colors, int colorNum, int index) {
        if(colors[index]!=0) {
            return colors[index] == colorNum;
        }

        colors[index] = colorNum;
        for(int i=0; i<graph[index].length; i++) {
            if(!isValidColor(graph, colors, -colorNum, graph[index][i])) {
                return false;
            }
        }
        return true;
    }
}