/**
 * Test cases:
 * 1: Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 */

class Q507 {
    private int getPerfectNumber(int prime) {
        return (1<<(prime-1)) * ((1<<prime)-1);
    }

    public boolean checkPerfectNumber(int num) {
        int[] primes = {2, 3, 5, 7, 13};
        for(int i=0; i<primes.length; i++) {
            if(getPerfectNumber(primes[i])==num) {
                return true;
            }
        }
        return false;
    }
}