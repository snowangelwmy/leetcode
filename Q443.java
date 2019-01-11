/**
 * Test cases:
 * 1: Input: ['a','a','b','b','c','c','c']
 * Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * 2: Input: ['a']
 * Output: Return 1, and the first 1 characters of the input array should be: ['a']
 * Explanation: Nothing is replaced.
 * 3: Input: ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 * Output: Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
 * Explanation: Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 */

class Q443 {
  public int compress(char[] chars) {
    int length = 0;
    if(chars==null||chars.length==0){
      return length;
    }

    char lastChar = chars[0];
    int lastCharCount = 1;
    int nextIndex = 0;
    for(int i=1; i<chars.length; i++){
      char c = chars[i];
      if(c==lastChar){
        lastCharCount++;
      } else {//c!=lastChar
        nextIndex = compressLastChar(chars, lastChar, lastCharCount, nextIndex);
        lastChar = c;
        lastCharCount = 1;
      }
    }

    return compressLastChar(chars, lastChar, lastCharCount, nextIndex);
  }

  private int compressLastChar(char[] chars, char lastChar, int lastCharCount, int nextIndex){
    //add lastChar
    chars[nextIndex] = lastChar;
    nextIndex++;
    if(lastCharCount>1){
      String lastCharCountStr = String.valueOf(lastCharCount);
      for(int j=0; j<lastCharCountStr.length(); j++){
        chars[nextIndex] = lastCharCountStr.charAt(j);
        nextIndex++;
      }
    }
    return nextIndex;
  }
}