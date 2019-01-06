/**
 * Test cases:
 * 1: Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        return bitCount(xor);
    }

    private int bitCount(int num) {
        int count = 0;
        int mask = 1;
        for(int i=0; i<32; i++){
            if((num&mask)!=0){
                count++;
            }
            mask<<=1;
        }
        return count;
    }
}