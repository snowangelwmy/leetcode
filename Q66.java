/**
 * Test cases:
 * 1: Input: [1,2,3], Output: [1,2,4]
 * 2: Input: [4,3,2,1], Output: [4,3,2,2]
 * 3: Input: [0], Output: [1]
 * 4: Input: [9, 9], Output: [1,0,0]
 */

import java.util.List;
import java.util.ArrayList;

class Q66 {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0){
            return digits;
        }

        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for(int i=digits.length-1;i>=0;i--){
            int num = 0;
            if(i==digits.length-1){
                num = digits[i]+1;
            } else {
                num = digits[i]+carry;
            }
            if(num>=10){
                num -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.add(0, num);
        }
        if(carry==1){
            result.add(0, 1);
        }

        int[] output = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            output[i] = result.get(i);
        }

        return output;
    }
}