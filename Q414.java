/**
 * Test cases:
 * 1: Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * 2: Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * 3: Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 4: Input: [1,2,2,5,3,5]
 * Output: 2
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 5 are both considered as maximum, and both numbers with value 2 are both considered as third maximum.
 */

class Q414 {
  public int thirdMax(int[] nums) {
    if(nums==null||nums.length==0){
      return Integer.MIN_VALUE;
    }

    Integer max = nums[0];
    Integer secondMax = null;
    Integer thirdMax = null;
    for(int i=1; i<nums.length; i++){
      int value = nums[i];
      if(value>max){
        thirdMax = secondMax;
        secondMax = max;
        max = value;
      } else if(secondMax==null||value>secondMax){//secondMax<value<=max
        if(value!=max){
          thirdMax = secondMax;
          secondMax = value;
        }
      } else if(thirdMax==null||value>thirdMax){//thirdMax<value<=secondMax
        if(value!=secondMax){
          thirdMax = value;
        }
      }
    }

    return thirdMax==null?max:thirdMax;
  }
}