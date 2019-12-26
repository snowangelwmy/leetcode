/**
 * Test cases:
 * 1: Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 2: Input: coins = [2], amount = 3
 * Output: -1
 */

class Q322 {
  public int coinChange(int[] coins, int amount) {
    if(amount<0||coins==null||coins.length==0) { return -1; }

    return coinChangeHelper(coins, amount, new int[amount+1]);
  }

  private int coinChangeHelper(int[] coins, int amount, int[] countCache) {
    if(amount<0) { return -1; }
    if(amount==0) { return 0; }
    if(countCache[amount]!=0) { return countCache[amount]; }
    int min = Integer.MAX_VALUE;
    for(int coin : coins) {
      int subCount = coinChangeHelper(coins, amount-coin, countCache);
      if(subCount>=0 && subCount+1<min) {
        min = subCount+1;
      }
    }
    countCache[amount] = (min==Integer.MAX_VALUE) ? -1 : min;
    return countCache[amount];
  }
}