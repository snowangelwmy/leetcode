/**
 * Test cases:
 * 1: Input: 2
 * Output: 2
 * Explanation:
 *
 * The first beautiful arrangement is [1, 2]:
 *
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 *
 * The second beautiful arrangement is [2, 1]:
 *
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 */

class Q526 {

    //https://leetcode.com/problems/beautiful-arrangement/solution/
    class Counter {
        int value;

        public Counter(int value) {
            this.value = value;
        }
    }

    public int countArrangement(int N) {
        if(N<=0) {
            return 0;
        }

        int[] nums = new int[N];
        for(int i=1; i<=N; i++) {
            nums[i-1] = i;
        }

        Counter counter = new Counter(0);
        permute(nums, 0, counter);
        return counter.value;
    }

    private void permute(int[] nums, int index, Counter counter) {
        if(index==nums.length-1) {
            if(nums[index]%(index+1)==0||(index+1)%nums[index]==0) {
                counter.value++;
            }
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            if(nums[index]%(index+1)==0||(index+1)%nums[index]==0) {
                permute(nums, index+1, counter);
            }
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}