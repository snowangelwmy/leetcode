/**
 * Test cases:
 * 1: Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 2: Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */

class Solution {
  public void rotate3(int[] nums, int k) {
    if(nums==null||nums.length<=1){
      return;
    }

    k = k%nums.length;
    if(k!=0){
      reverse(nums, 0, nums.length-1);
      reverse(nums, 0, k-1);
      reverse(nums, k, nums.length-1);
    }
  }

  private void reverse(int[] nums, int low, int high){
    if(low>=high){
      return;
    }

    //low<high
    for(int i=low; i<=(low+high)/2; i++){
      int another = high-(i-low);
      if(i!=another){
        int temp = nums[i];
        nums[i] = nums[another];
        nums[another] = temp;
      }
    }
  }

  //Extra space is used
  public void rotate2(int[] nums, int k) {
    if(nums==null||nums.length<=1){
      return;
    }

    int[] tempNums = new int[nums.length];
    for(int i=0; i<nums.length; i++){
      int newIdx = (i+k)%nums.length;
      tempNums[newIdx] = nums[i];
    }

    for(int i=0; i<nums.length; i++){
      nums[i] = tempNums[i];
    }
  }

  //Time Limit Exceeded
  public void rotate1(int[] nums, int k) {
    if(nums==null||nums.length<=1){
      return;
    }

    for(int i=0; i<k; i++){
      rotateOne(nums);
    }
  }

  private void rotateOne(int[] nums){
    int last = nums[nums.length-1];
    for(int i=nums.length-2; i>=0; i--){
      nums[i+1]=nums[i];
    }
    nums[0] = last;
  }
}