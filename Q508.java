/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Q508 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int[] findFrequentTreeSum(TreeNode root) {
    if(root==null) {
      return new int[0];
    }
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> lookup = new HashMap<>(); // sum -> frequency
    calculateSum(root, lookup);
    int largestFrequency = 0;
    for(Map.Entry<Integer, Integer> entry: lookup.entrySet()) {
      if(entry.getValue() > largestFrequency) {
        largestFrequency = entry.getValue();
      }
    }
    for(Map.Entry<Integer, Integer> entry: lookup.entrySet()) {
      if(entry.getValue() == largestFrequency) {
        result.add(entry.getKey());
      }
    }
    int[] answer = new int[result.size()];
    for(int i=0; i<result.size(); i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }

  private int calculateSum(TreeNode root, Map<Integer, Integer> lookup) {
    int sum = root.val;
    if(root.left==null && root.right==null) {
      if(!lookup.containsKey(sum)) {
        lookup.put(sum, 0);
      }
      lookup.put(sum, lookup.get(sum)+1);
      return sum;
    }
    if(root.left!=null) {
      sum += calculateSum(root.left, lookup);
    }
    if(root.right!=null) {
      sum += calculateSum(root.right, lookup);
    }
    if(!lookup.containsKey(sum)) {
      lookup.put(sum, 0);
    }
    lookup.put(sum, lookup.get(sum)+1);
    return sum;
  }
}