/**
 * Test cases:
 * 1: Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation: Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * 2: Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation: We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 */

class Q769 {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max==i) {
                count++;
            }
        }
        return count;
    }
}