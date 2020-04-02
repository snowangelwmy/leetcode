/**
 * Test cases:
 * 1: Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * 2: Input: [0]
 * Output: 0
 */

class Q421 {

    class TrieNode {
        TrieNode left;
        TrieNode right;
        Integer num;
    }

    //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/499007/Java-oror-Complete-Thought-Process
    public int findMaximumXOR(int[] nums) {
        if(nums==null||nums.length<2) {
            return 0;
        }

        TrieNode root = new TrieNode();
        for(int num : nums) {
            insertNum(root, num);
        }

        int maxXOR = Integer.MIN_VALUE;
        for(int num : nums) {
            int opp = findOpposite(root, num);
            maxXOR = Math.max(maxXOR, num^opp);
        }

        return maxXOR;
    }

    private void insertNum(TrieNode root, int num) {
        TrieNode cur = root;
        for(int i=31; i>=0; i--) {
            int bit = (num>>i) & 1;
            if(bit==0) {
                if(cur.left==null) {
                    cur.left = new TrieNode();
                }
                cur = cur.left;
            } else {//bit==1
                if(cur.right==null) {
                    cur.right = new TrieNode();
                }
                cur = cur.right;
            }
        }
        cur.num = num;
    }

    private int findOpposite(TrieNode root, int num) {
        TrieNode cur = root;
        for(int i=31; i>=0; i--) {
            int bit = (num>>i) & 1;
            if(bit==0) {
                if(cur.right==null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            } else {//bit==1
                if(cur.left==null) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
        }
        return cur.num;
    }
}