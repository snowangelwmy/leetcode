/**
 * Test cases:
 * 1: Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 2: Input: [2,1]
 * Output: 0
 * 3: Input: [1,2,3,0,2]
 * Output: 3
 */

class Q309 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/446609/Java-easy-understand-DP-beat-100
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) {
            return 0;
        }

        int length = prices.length + 1;
        int[] rest = new int[length];
        int[] bought = new int[length];
        int[] sold = new int[length];

        rest[0] = 0;
        bought[0] = Integer.MIN_VALUE;
        sold[0] = 0;
        for(int i=1; i<length; i++) {
            rest[i] = Math.max(rest[i-1], sold[i-1]);
            bought[i] = Math.max(bought[i-1], rest[i-1]-prices[i-1]);
            sold[i] = bought[i-1]+prices[i-1];
        }

        return Math.max(rest[length-1], sold[length-1]);
    }
}