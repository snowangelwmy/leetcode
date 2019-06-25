/**
 * Test cases:
 * 1: Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 * 2: Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 * 3: Input: n = 3, edges = [[0,1],[0,2]]
 *
 *    0
 *   / \
 *  1  2
 *
 *  Output: [0]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class Q310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> roots = new ArrayList<>();
    if(n<=0) {
      return roots;
    }
    if(n==1) {
      roots.add(n-1);
      return roots;
    }

    Map<Integer, HashSet<Integer>> neighbors = new HashMap<>();
    for(int i=0; i<n; i++) {
      neighbors.put(i, new HashSet<Integer>());
    }
    for(int[] edge : edges) {
      neighbors.get(edge[0]).add(edge[1]);
      neighbors.get(edge[1]).add(edge[0]);
    }

    List<Integer> leaves = new ArrayList<>();
    for(int i=0; i<n; i++) {
      if(neighbors.get(i).size()==1) {
        leaves.add(i);
      }
    }
    while(n>2) {
      n-=leaves.size();
      List<Integer> newLeaves = new ArrayList<>();
      for(Integer leaf : leaves) {
        Integer neighbor = neighbors.get(leaf).iterator().next();
        neighbors.get(neighbor).remove(leaf);
        if(neighbors.get(neighbor).size()==1) {
          newLeaves.add(neighbor);
        }
      }
      leaves = newLeaves;
    }
    return leaves;
  }
}