package programmers.online.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class 프로세스 {
    /*
     * 시간 복잡도 : O(NlogN) -> 정렬 알고리즘
     * 공간 복잡도 : O(N) -> queue 에 N개의 원소가 들어 갈 수 있다.
     */
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> q = new LinkedList<>();
        for(int i : priorities){
            q.add(i);
        }
        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while(!q.isEmpty()){
            int i = q.poll();
            if (priorities[size - answer] == i){
                answer++;
                l--;
                if (l < 0) break;
            } else{
                q.add(i);
                l--;
                if (l < 0) l = q.size() - 1;
            }
        }
        return answer;
    }
}
