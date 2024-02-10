package leet.top_interview_150._06_stack;

import java.util.Stack;

/*
 * https://leetcode.com/problems/basic-calculator/?envType=study-plan-v2&envId=top-interview-150
 */
public class _05_basic_calculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0; // 진행 중 중간 결과들을 저장
        int operand = 0; // 숫자들을 표현하기 위한 매개체.
        int sign = 1;   // 1 : +, -1 : -

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                operand = operand * 10 + (int) (ch - '0');
            } else if (ch == '+'){
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-'){
                result += sign * operand;
                operand = 0;
                sign = -1;
            } else if (ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign =1;
            } else if (ch == ')'){
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result += operand * sign;
    }
}
