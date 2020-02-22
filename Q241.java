/**
 * Test cases:
 * 1: Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 2: Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */

import java.util.List;
import java.util.ArrayList;

class Q241 {

    private static final char[] OPS = {'+', '-', '*'};

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if(input==null||input.length()==0) {
            return result;
        }

        boolean noOp = true;
        for(int i=0; i<OPS.length; i++) {
            if(input.indexOf(OPS[i])!=-1) {
                noOp = false;
                break;
            }
        }

        if(noOp) {
            try {
                result.add(Integer.parseInt(input));
            } catch(Exception ex) {
                System.out.println(ex.toString());
            } finally {
                return result;
            }
        }

        for(int i=0; i<OPS.length; i++) {
            int start = 0;
            while(start<input.length()) {
                int opIndex = input.indexOf(OPS[i], start);
                if(opIndex!=-1) {
                    List<Integer> firstNums = diffWaysToCompute(input.substring(0, opIndex));
                    List<Integer> secondNums = diffWaysToCompute(input.substring(opIndex+1));
                    for(Integer firstNum : firstNums) {
                        for(Integer secondNum : secondNums) {
                            switch(i) {
                                case 0:
                                    result.add(firstNum+secondNum);
                                    break;
                                case 1:
                                    result.add(firstNum-secondNum);
                                    break;
                                case 2:
                                    result.add(firstNum*secondNum);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    start = opIndex + 1;
                } else {
                    start = input.length();
                }
            }
        }

        return result;
    }
}