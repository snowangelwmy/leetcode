/**
 * Test cases:
 * 1: Input: "1 + 1"
 * Output: 2
 * 2: Input: " 2-1 + 2 "
 * Output: 3
 * 3: Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */

import java.util.Stack;

class Q224 {

    //https://leetcode.com/problems/basic-calculator/solution/
    private static final Character LEFT = '(';
    private static final Character RIGHT = ')';
    private static final Character BLANK = ' ';
    private static final Character PLUS = '+';
    private static final Character MINUS = '-';

    public int calculate(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        int operand = 0;
        int weight = 0;
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) {
                if(operand!=0||weight!=0) {
                    stack.push(String.valueOf(operand));
                    operand = 0;
                    weight = 0;
                }

                if(c==LEFT) {
                    Integer subResult = evaluate(stack);
                    stack.pop(); //pop the right parenthese
                    stack.push(subResult.toString());
                } else if(c==PLUS||c==MINUS||c==RIGHT) {
                    stack.push(String.valueOf(c));
                }
            } else {
                operand = (int)((c-'0')*(Math.pow(10, weight))) + operand;
                weight++;
                if(i==0) {
                    stack.push(String.valueOf(operand));
                }
            }
        }

        return evaluate(stack);
    }

    private Integer evaluate(Stack<String> stack) {
        Integer result = 0;
        if(stack.isEmpty()) {
            return result;
        }

        //assume the original String s is a valid expression
        result = Integer.parseInt(stack.pop());
        String op = null;
        while(!stack.isEmpty() && !stack.peek().equals(RIGHT.toString())) {
            if(op==null) {
                op = stack.pop();
            } else {
                Integer operand = Integer.parseInt(stack.pop());
                if(op.equals(PLUS.toString())) {
                    result += operand;
                    op = null;
                } else if(op.equals(MINUS.toString())) {
                    result -= operand;
                    op = null;
                }
            }
        }

        return result;
    }
}