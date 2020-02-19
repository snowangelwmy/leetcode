/**
 * Test cases:
 * 1: Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 2: Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 *              1 + 99 = 100, 99 + 100 = 199
 */

class Q306 {
    public boolean isAdditiveNumber(String num) {
        if(num==null||num.length()<3) {
            return false;
        }

        for(int i=0; i<num.length()-2; i++) {
            for(int j=i+1; j<num.length()-1; j++) {
                String first = num.substring(0, i+1);
                String second = num.substring(i+1, j+1);
                String remaining = num.substring(j+1);
                if(isAdditive(first, second, remaining)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditive(String first, String second, String remaining) {
        if(hasLeadingZero(first)||hasLeadingZero(second)) {
            return false;
        }

        long firstNum = Long.parseLong(first);
        long secondNum = Long.parseLong(second);
        String third = Long.toString(firstNum + secondNum);
        if(remaining.startsWith(third)) {
            if(remaining.length()==third.length()) {
                return true;
            }
            String nextFirst = second;
            String nextSecond = third;
            String nextRemaining = remaining.substring(third.length());
            return isAdditive(nextFirst, nextSecond, nextRemaining);
        }

        return false;
    }

    private boolean hasLeadingZero(String num) {
        return num.length()>1 && num.charAt(0) == '0';
    }
}