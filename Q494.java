/**
 * Test cases:
 * 1: Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */

import java.util.Arrays;

class Q494 {

  //2: Recursion with Memoization
  public int findTargetSumWays(int[] nums, int S) {
    int[][] memo = new int[nums.length][2001];
    for(int[] sums: memo) {
      Arrays.fill(sums, Integer.MIN_VALUE);
    }
    return calculate(nums, 0, 0, S, memo);
  }

  private int calculate(int[] nums, int index, int sum, int target, int[][] memo) {
    if(index==nums.length) {
      if(sum==target) {
        return 1;
      }
      return 0;
    }

    if(memo[index][sum+1000]!=Integer.MIN_VALUE) {
      return memo[index][sum+1000];
    }

    int add = calculate(nums, index+1, sum+nums[index], target, memo);
    int subtract = calculate(nums, index+1, sum-nums[index], target, memo);
    memo[index][sum+1000] = add + subtract;
    return memo[index][sum+1000];
  }

  //1: Brute Force Approach
  private class Counter {
    int num;
  }

  public int findTargetSumWays0(int[] nums, int S) {
    Counter counter = new Counter();
    calculate(nums, 0, 0, S, counter);
    return counter.num;
  }

  private void calculate(int[] nums, int index, int sum, int target, Counter counter) {
    if(index==nums.length) {
      if(sum==target) {
        counter.num++;
      }
      return;
    }

    calculate(nums, index+1, sum+nums[index], target, counter);
    calculate(nums, index+1, sum-nums[index], target, counter);
  }
}