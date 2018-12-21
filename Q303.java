/**
 * Test cases:
 * 1: Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */

class NumArray {

  private int[] sums;

  public NumArray(int[] nums) {
    sums = new int[nums.length];
    int sum = 0;
    for(int i=0; i<nums.length; i++){
      sum += nums[i];
      sums[i] = sum;
    }
  }

  public int sumRange(int i, int j) {
    if(i<0||j<0||j<i||i>=sums.length||j>=sums.length){
      System.out.println("Invalid parameters!!!");
      return Integer.MIN_VALUE;
    }
    if(i==0) {
      return sums[j];
    } else {
      return sums[j] - sums[i-1];
    }
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */