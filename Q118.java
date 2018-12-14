/**
 *
 * Test cases:
 * 1: Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> rows = new ArrayList<>();
    if(numRows<=0){
      return rows;
    }

    for(int i=0; i<numRows; i++){
      List<Integer> nums = new ArrayList<>(i+1);
      for(int j=0; j<i+1; j++){
        if(j==0||j==i){
          nums.add(1);
        } else {//0<j<i
          nums.add(rows.get(i-1).get(j-1) + rows.get(i-1).get(j));
        }
      }
      rows.add(nums);
    }

    return rows;
  }
}