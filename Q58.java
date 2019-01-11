/**
 * Test cases:
 * 1: Input: "Hello World", Output: 5
 * 2: Input: "a ", Output: 1
 * 3: Input: "b   a    ", Output: 1
 */

class Q58 {
    public int lengthOfLastWord(String s) {
        if(s==null){
            return 0;
        }
        int lastLength = 0;
        int curLength = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                if(curLength>0){
                    lastLength = curLength;
                }
                curLength = 0;
            } else {
                curLength++;
            }
        }
        return curLength==0?lastLength:curLength;
    }
}