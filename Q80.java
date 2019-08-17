/**
 * Test cases:
 * 1: Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * 2: Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */

class Q80 {
    public int removeDuplicates(int[] nums) {
        if(nums==null) {
            return 0;
        } else if(nums.length<3) {
            return nums.length;
        }

        int last = 2;
        int next = 2;
        while(next < nums.length) {
            if(nums[last-2] != nums[next]) {
                nums[last] = nums[next];
                last++;
            }
            next++;
        }
        return last;
    }
}