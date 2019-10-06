/**
 * Test cases:
 * 1: Input: matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * Output: return 13.
 */

import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;

class Q378 {

  //https://www.cnblogs.com/grandyang/p/6854825.html
  //template 2    查找第一个不小于目标值的数
  public int kthSmallest(int[][] matrix, int k) {
    if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
      return 0;
    }

    int start = matrix[0][0];
    int end = matrix[matrix.length-1][matrix[0].length-1];
    while(start<end) {
      int mid = (start+end)/2;
      int count = getSmallerCount(matrix, mid);
      if(count<k) {
        start = mid+1;
      } else {
        end = mid;
      }
    }
    return end;
  }

  private int getSmallerCount(int[][] matrix, int mid) {
    int rowIndex = matrix.length-1;
    int colIndex = 0;
    int count = 0;
    while(rowIndex>=0&&colIndex<matrix[0].length) {
      if(mid>=matrix[rowIndex][colIndex]) {
        count += rowIndex+1;
        colIndex++;
      } else {
        rowIndex--;
      }
    }
    return count;
  }


  private static final String DELIMITER = ",";

  class Node {
    int row;
    int col;
    int val;

    Node(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }

  //Solution explanation: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/358541/Detailed-intution-Priority-queue
  public int kthSmallest0(int[][] matrix, int k) {
    if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
      return 0;
    }

    PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
      public int compare(Node node1, Node node2) {
        return node1.val-node2.val;
      }
    });
    Set<String> visited = new HashSet<>();
    queue.offer(new Node(0, 0, matrix[0][0]));
    visited.add(0+DELIMITER+0);
    int count = 0;
    Node result = null;
    while(count<k&&!queue.isEmpty()) {
      result = queue.poll();
      int row = result.row;
      int col = result.col;
      int nextRow = row+1;
      int nextCol = col;
      if(nextRow<matrix.length && !visited.contains(nextRow+DELIMITER+nextCol)) {
        queue.offer(new Node(nextRow, nextCol, matrix[nextRow][nextCol]));
        visited.add(nextRow+DELIMITER+nextCol);
      }
      nextRow = row;
      nextCol = col+1;
      if(nextCol<matrix[0].length && !visited.contains(nextRow+DELIMITER+nextCol)) {
        queue.offer(new Node(nextRow, nextCol, matrix[nextRow][nextCol]));
        visited.add(nextRow+DELIMITER+nextCol);
      }
      count++;
    }
    if(count<k) {
      return 0;
    } else {
      return result.val;
    }
  }
}