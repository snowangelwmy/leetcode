/**
 * Test cases:
 * 1: Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
 *              No matter 1, 2, or 3 stones you remove, the last stone will always be
 *              removed by your friend.
 */

class Q292 {
  public boolean canWinNim(int n) {
    if(n<=0){
      System.out.println("Invalid parameter!!!");
      return false;
    }
    return (n%4)!=0;
  }
}