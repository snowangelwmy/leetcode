/**
 * Test cases:
 * 1: Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 2: Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation: 0.0, 00, 0001 or 00.01 are not allowed.
 * 3: Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 4: Input: "(100)"
 * Output: [(10, 0)]
 * Explanation: 1.0 is not allowed.
 */

import java.util.List;
import java.util.ArrayList;

class Q816 {
    public List<String> ambiguousCoordinates(String S) {
        List<String> results = new ArrayList<>();
        if(S==null||S.length()<3) {
            return results;
        }

        String source = S.substring(1, S.length()-1);
        for(int i=0; i<source.length()-1; i++) {
            List<String> firstNums = getNums(source.substring(0, i+1));
            List<String> secondNums = getNums(source.substring(i+1));
            if(!firstNums.isEmpty()&&!secondNums.isEmpty()) {
                for(int j=0; j<firstNums.size(); j++) {
                    for(int k=0; k<secondNums.size(); k++) {
                        results.add("("+firstNums.get(j)+", " + secondNums.get(k)+")");
                    }
                }
            }
        }

        return results;
    }

    private List<String> getNums(String S) {
        List<String> nums = new ArrayList<>();
        if(S.length()==1) {
            nums.add(S);
            return nums;
        }

        //S.length()>1
        if(S.startsWith("0")) {
            if(S.endsWith("0")) {
                return nums;
            } else {
                nums.add(S.substring(0, 1)+"."+S.substring(1));
                return nums;
            }
        } else {
            nums.add(S);
            if(S.endsWith("0")) {
                return nums;
            } else {
                for(int i=0; i<S.length()-1; i++) {
                    nums.add(S.substring(0, i+1)+"."+S.substring(i+1));
                }
                return nums;
            }
        }
    }
}