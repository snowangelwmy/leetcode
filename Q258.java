/**
 * Test cases:
 * 1: Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * 2: Input: 9
 * Output: 9
 */

class Solution {

  //without any loop/recursion in O(1) runtime
  public int addDigits(int num) {
    if(num<0){
      return -1;
    } else if(num==0){
      return 0;
    } else {
      return (num%9==0)?9:(num%9);
    }
  }

  public int addDigits1(int num) {
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