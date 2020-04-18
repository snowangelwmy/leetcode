/**
 * Test cases:
 * 1: Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */

import java.util.Arrays;

class Q581 {

    public int findUnsortedSubarray(int[] nums) {
        if(nums==null||nums.length<2) {
            return 0;
        }

        int[] numsCopy = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(numsCopy);

        int leftMost = -1;
        int rightMost = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=numsCopy[i]) {
                leftMost = leftMost==-1||i<leftMost? i : leftMost;
                rightMost = rightMost==-1||i>rightMost ? i : rightMost;
            }
        }

        return leftMost==-1&&rightMost==-1? 0 : rightMost-leftMost+1;
    }

    public int findUnsortedSubarray0(int[] nums) {
        if(nums==null||nums.length<2) {
            return 0;
        }

        int leftMost = -1;
        int rightMost = -1;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]>nums[j]) {
                    leftMost = leftMost==-1||i<leftMost ? i : leftMost;
                    rightMost = rightMost==-1||j>rightMost ? j : rightMost;
                }
            }
        }

        return leftMost==-1&&rightMost==-1? 0 : rightMost-leftMost+1;
    }
}