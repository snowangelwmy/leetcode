/**
 * Test cases:
 * 1: Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 */

import java.lang.StringBuilder;

class Q541 {
    public String reverseStr(String s, int k) {
        if(s==null||s.length()==0||k<=0) {
            return s;
        }

        int len = s.length();
        int residue = len%(2*k);
        int quotient = len/(2*k);
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<quotient; i++) {
            for(int j=k-1; j>=0; j--) {
                char c = s.charAt(i*2*k+j);
                builder.append(c);
            }
            for(int j=k; j<2*k; j++) {
                char c = s.charAt(i*2*k+j);
                builder.append(c);
            }
        }
        if(residue<k) {
            for(int j=residue-1; j>=0; j--) {
                char c = s.charAt(quotient*2*k+j);
                builder.append(c);
            }
        } else {//k=<residue<2*k
            for(int j=k-1; j>=0; j--) {
                char c = s.charAt(quotient*2*k+j);
                builder.append(c);
            }
            for(int j=k; j<residue; j++) {
                char c = s.charAt(quotient*2*k+j);
                builder.append(c);
            }
        }

        return builder.toString();
    }
}