/**
 * Test cases:
 * 1: Input: "PPALLP"
 * Output: True
 * 2: Input: "PPALLL"
 * Output: False
 */

class Q551 {
    public boolean checkRecord(String s) {
        if(s==null||s.length()==0) {
            return true;
        }

        int[] dpL = new int[s.length()];
        dpL[0] = s.charAt(0)=='L'? 1 : 0;
        int countA = s.charAt(0)=='A'? 1 : 0;
        int countL = dpL[0];
        for(int i=1; i<s.length(); i++) {
            int c = s.charAt(i);
            if(c=='L') {
                dpL[i] = 1 + dpL[i-1];
                countL = Math.max(countL, dpL[i]);
            } else {
                dpL[i] = 0;
                if(c=='A') {
                    countA++;
                }
            }
        }

        return countA<=1 && countL<=2;
    }
}