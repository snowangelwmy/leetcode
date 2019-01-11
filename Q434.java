/**
 * Test cases:
 * 1: Input: "Hello, my name is John"
 * Output: 5
 */

class Q434 {
  public int countSegments(String s) {
    int count = 0;
    if(s==null||s.length()==0){
      return count;
    }
    int lastStart = -1;
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(c==' '){
        if(lastStart>=0){
          count++;
          lastStart = -1;
        }
      } else {
        if(lastStart==-1){
          lastStart = i;
        }
      }
    }
    if(lastStart>=0){
      count++;
    }
    return count;
  }
}