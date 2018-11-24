/**
 * Test cases:
 * 1: Input: 121, Output: true
 * 2: Input: -121, Output: false
 * 3: Input: 10, Output: false
 */

class Solution {
    public boolean isPalindrome(int x) {
        String xString = Integer.toString(x);
        if(xString==null){
            return false;
        }

        int length = xString.length();
        for(int i=0; i<length/2; i++){
            if(xString.charAt(i)!=xString.charAt(length-1-i)){
                return false;
            }
        }

        return true;
    }
}