package programmers.online.sort;

import java.util.Arrays;

public class PRO_HINDEX {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름 차순 정렬
        int answer = 0;
        for(int i = 0; i < citations.length; i++){
            int small = Math.min(citations.length - i, citations[i]);
            answer = Math.max(small, answer);
        }
        return answer;
    }
}
