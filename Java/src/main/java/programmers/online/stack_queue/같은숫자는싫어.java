package programmers.online.stack_queue;

import java.util.Stack;

/*
 * link of prob : https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 * 배열의 원소는 숫자 0 부터 9까지로 이루어져 있을 때, 배열 arr에서 연속적으로 나타나는 숫자 하나만 남기고 제거하는 문제
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 */
public class 같은숫자는싫어 {

    /*
     * 시간 복잡도 : O(N) => 배열을 순회해야 하므로
     * 공간 복잡도 : O(N) => 최악의 경우 모든 원소를 Stack에 저장해야 하므로
     */
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        // 연속하는 숫자가 아닐 경우 stack에 집어넣는 과정.
        for(int number : arr){
            if (stack.isEmpty()){
                stack.push(number);
            } else{
                int cur = stack.peek();
                if (cur != number){
                    stack.push(number);
                }
            }
        }
        int[] answer = new int[stack.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = stack.get(i);
        }
        return answer;
    }
}
