/**
 *
 * Test cases:
 * 1: Input: 3
 * Output: [1,3,3,1]
 * 2: Input: 0
 * Output: [1]
 *
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> getRow(int rowIndex) {
    if(rowIndex<0){
      return new ArrayList<>();
    }

    List<Integer> nums = new ArrayList<>(rowIndex+1);
    for(int i=0; i<=rowIndex; i++){
      nums.add(0);
    }
    for(int i=0; i<=rowIndex; i++){
      for(int j=i; j>=0; j--){
        if(j==i||j==0){
          nums.set(j, 1);
        } else {
          nums.set(j, nums.get(j-1)+nums.get(j));
        }
      }
    }
    return nums;
  }
}