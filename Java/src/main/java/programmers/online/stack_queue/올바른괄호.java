package programmers.online.stack_queue;

import java.util.Stack;

/*
 * link of prob : https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
 * 올바르게 괄호가 지어져있는지 확인할 수 있는 메서드를 만들어라.
 * 괄호가 바르게 짝지어짐 -> '(' 문자로 열렸으면 ')' 문자로 닫혀야 한다.
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 */
public class 올바른괄호 {

    /*
     * 시간 복잡도 : O(N) -> 문자 s의 문자열 길이
     * 공간 복잡도 : O(N) -> 모든 문자열들이 Stack에 담길 경우
     */
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        // 기호가 ( 일 경우 )를 Stack에 집어 넣는다.
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
