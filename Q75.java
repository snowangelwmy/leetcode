/**
 * Test cases:
 * 1: Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */

class Q75 {

    //a one-pass algorithm
    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0) {
            return;
        }

        int nextZeroIndex = 0;
        int nextTwoIndex = nums.length - 1;
        int index = 0;
        while(index < nums.length && nextZeroIndex < nextTwoIndex) {
            if(nums[index] == 0) {
                swap(nums, nextZeroIndex, index);
                nextZeroIndex++;
                index++;
            } else if(nums[index] == 2 && index < nextTwoIndex) {
                swap(nums, nextTwoIndex, index);
                nextTwoIndex--;
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    //a two-pass algorithm
    public void sortColors0(int[] nums) {
        if(nums==null||nums.length==0) {
            return;
        }

        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for(int num : nums) {
            switch(num) {
                case 0:
                    redCount++;
                    break;
                case 1:
                    whiteCount++;
                    break;
                case 2:
                    blueCount++;
                    break;
                default:
                    break;
            }
        }
        int next = 0;
        for(int i=0; i<redCount; i++) {
            nums[next++] = 0;
        }
        for(int i=0; i<whiteCount; i++) {
            nums[next++] = 1;
        }
        for(int i=0; i<blueCount; i++) {
            nums[next++] = 2;
        }
        return;
    }
}