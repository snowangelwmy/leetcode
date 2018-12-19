/**
 * Test cases:
 * 1: Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 */

class Solution {
  public int addDigits(int num) {
    if(num<0){
      return -1;
    }
    int temp = num;
    while(temp>=10){
      temp = addAllDigits(temp);
    }
    return temp;
  }

  private int addAllDigits(int num){
    int sum = 0;
    while(num!=0){
      sum += num%10;
      num /= 10;
    }
    return sum;
  }
}