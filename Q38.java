/**
 * Test cases:
 * 1: Input: 1, Output: 1
 * 2: Input: 2, Output: 11
 * 3: Input: 3, Output: 21
 * 4: Input: 4, 0, Output: 1211
 * 5: Input: 5, 0, Output: 111221
 */

import java.lang.StringBuilder;

class Q38 {
    public String countAndSay(int n) {
        if (n<1){
            return "";
        }

        String result = "1";
        for(int i=1; i<n; i++){
            result = countAndSayNext(result);
        }
        return result;
    }

    private static String countAndSayNext(String input){
        StringBuilder output = new StringBuilder();

        char c = input.charAt(0);
        int count = 1;
        for(int i=1; i<input.length(); i++){
            if(input.charAt(i)!=c){
                output.append(count+""+c);
                c = input.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        output.append(count+""+c);
        return output.toString();
    }
}