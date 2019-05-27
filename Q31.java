/**
 * Test cases:
 * 1: Input -> Output:
 * 1,2,3 → 1,3,2
 *
 * 2: Input -> Output:
 * 3,2,1 → 1,2,3
 *
 * 3: Input -> Output:
 * 1,1,5 → 1,5,1
 */

class Q31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i]) {
            i--;
        }
        if(i>=0) {
            for(int j=nums.length-1; j>i; j--) {
                if(nums[j]>nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int start = i;
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start++, end--);
        }
    }
}