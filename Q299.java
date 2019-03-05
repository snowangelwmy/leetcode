/**
 * Test cases:
 * 1: Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * 2: Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 */

class Q299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for(int i=0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if(s==g) {
                bulls++;
            } else {
                if(nums[s]<0) cows++;
                if(nums[g]>0) cows++;
                nums[s]++;
                nums[g]--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}