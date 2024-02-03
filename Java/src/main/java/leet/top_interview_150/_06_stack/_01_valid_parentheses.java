package leet.top_interview_150._06_stack;


import java.util.Stack;

public class _01_valid_parentheses {

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(N)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c == '('){
                stack.push(')');
            } else if (c == '['){
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else {
                if (stack.isEmpty()){
                    return false;
                } else {
                    char top = stack.pop();
                    if (top != c){
                        return false;
                    }
                }

            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
