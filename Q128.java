/**
 * Test cases:
 * 1: Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

class Q128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestLength = 1;
        int currentLength = 1;
        for(int i=1; i<nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                if (nums[i]==nums[i-1]+1) {
                    currentLength++;
                } else {
                    longestLength = Math.max(longestLength, currentLength);
                    currentLength = 1;
                }
            }
        }

        return Math.max(longestLength, currentLength);
    }
}