/**
 * Test cases:
 * 1: Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */

class Q283 {
  public void moveZeroes(int[] nums) {
    if(nums==null||nums.length==0){
      return;
    }
    int zeroCount = 0;
    for(int i=0; i<nums.length; i++){
      if(nums[i]==0){
        zeroCount++;
      }
    }
    int next = 0;
    for(int i=0; i<nums.length; i++){
      if(nums[i]!=0){
        nums[next] = nums[i];
        next++;
      }
    }
    for(int i=0; i<zeroCount; i++){
      nums[nums.length-1-i] = 0;
    }
  }

  public void moveZeroes1(int[] nums) {
    if(nums==null||nums.length==0) {
      return;
    }

    int nextPos = 0;
    int nextIdx = 0;
    while(nextPos<nums.length) {
      while(nextIdx<nums.length&&nums[nextIdx]==0) {
        nextIdx++;
        continue;
      }

      if(nextIdx<nums.length) {
        nums[nextPos++] = nums[nextIdx++];
      } else {
        nums[nextPos++] = 0;
      }
    }
  }
}