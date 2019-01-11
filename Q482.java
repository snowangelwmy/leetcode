/**
 * Test cases:
 * 1: Input: S = "5F3Z-2e-9-w", K = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * 2: Input: S = "2-5g-3-J", K = 2
 * Output: "2-5G-3J"
 * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 */

public class Q482 {

  public String licenseKeyFormatting(String S, int K) {
    if(S==null||S.length()==0) {
      return S;
    }

    String newS = String.join("", S.split("-")).toUpperCase();
    StringBuilder builder = new StringBuilder();
    builder.append(newS);
    int count = 0;
    for(int i=newS.length()-1; i>=0; i--) {
      count++;
      if(count==K && i>0) {
        builder.insert(i, "-");
        count = 0;
      }
    }
    return builder.toString();
  }

}
