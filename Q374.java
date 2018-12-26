/**
 * Test cases:
 * 1: Input: n = 10, pick = 6
 * Output: 6
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int low = 1;
    int high = n;
    while(low<=high) { //to eliminate invalid input parameters
      int mid = low+(high-low)/2; //to avoid integer overflow
      int guessResult = guess(mid);
      if(guessResult==0){
        return mid;
      } else if(guessResult==-1) {
        high = mid-1;
      } else {//guessResult==1
        low = mid+1;
      }
    }

    return -1;
  }
}