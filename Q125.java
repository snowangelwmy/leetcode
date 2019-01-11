/**
 * Test cases:
 * 1: Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 2: Input: "race a car"
 * Output: false
 */

import java.lang.StringBuilder;

class Q125 {
    public boolean isPalindrome(String s) {
        if(s==null){
            return false;
        } else if(s.length()==0){
            return true;
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                builder.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        String newS = builder.toString();
        for(int i=0; i<newS.length()/2; i++){
            if(newS.charAt(i)!=newS.charAt(newS.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}