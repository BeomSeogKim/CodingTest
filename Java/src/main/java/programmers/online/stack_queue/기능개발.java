package programmers.online.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */
public class 기능개발 {
    /*
     * 시간 복잡도 : O(N) -> progresses 의 길이 만큼 for 문 순회
     * 공간 복잡도 : O(N) -> LinkedList, ArrayList에 N만큼 담길 수 있다.
     */
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int res = (int) Math.ceil(remain);

            // 작업 걸리는 시간이 더 클 경우 이전 작업 저장 후 새로 시작
            if (!q.isEmpty() && res > q.peek()){
                l.add(q.size());
                q.clear();
            }

            q.offer(res);

        }
        l.add(q.size());

        int[] answer = new int[l.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}
