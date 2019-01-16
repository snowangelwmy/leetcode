/**
 * Test cases:
 * 1: Input: "USA"
 * Output: True
 * 2: Input: "FlaG"
 * Output: False
 */

class Q520 {
    public boolean detectCapitalUse(String word) {

        if(word==null||word.length()==0) {
            return false;
        }

        if(allUpperCase(word)||allLowerCase(word)||firstCharUpperCase(word)) {
            return true;
        }

        return false;
    }

    private boolean allUpperCase(String word) {
        return allSameCase(word, true);
    }

    private boolean allLowerCase(String word) {
        return allSameCase(word, false);
    }

    private boolean firstCharUpperCase(String word) {
        if(word.length()==1) {
            return false;
        }

        char c = word.charAt(0);
        if(Character.isLowerCase(c)) {
            return false;
        }
        for(int i=1; i<word.length(); i++) {
            c = word.charAt(i);
            if(!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean allSameCase(String word, boolean isUpperCase) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if((isUpperCase && !Character.isUpperCase(c)) ||
                    (!isUpperCase && Character.isUpperCase(c))) {
                return false;
            }
        }
        return true;
    }
}