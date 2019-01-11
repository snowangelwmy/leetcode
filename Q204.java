/**
 * Test cases:
 * 1: Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

class Q204 {
  public int countPrimes2(int n) {
    int[] isPrime = new int[n];
    //ignore index 0 and 1
    for(int i=2; i<n; i++) {
      isPrime[i] = 1;
    }
    int count = 0;
    for(int i=2; i<n; i++){
      if(isPrime[i]==1){
        int prime = i;
        count++;
        for(int j=2; j*prime<n; j++){
          isPrime[j*prime] = 0;
        }
      }
    }
    return count;
  }

  //Time Limit Exceeded
  public int countPrimes1(int n) {
    int[] isPrime = new int[n];
    //ignore index 0 and 1
    for(int i=2; i<n; i++) {
      isPrime[i] = 1;
    }
    int count = 0;
    for(int i=2; i<n; i++){
      if(isPrime[i]==1){
        int prime = i;
        count++;
        for(int j=i+1; j<n; j++){
          if(j%prime==0){
            isPrime[j] = 0;
          }
        }
      }
    }
    return count;
  }
}