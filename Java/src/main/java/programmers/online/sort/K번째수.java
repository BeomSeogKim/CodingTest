package programmers.online.sort;

import java.util.Arrays;

/*
 * url of prob : https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하는
 */
public class K번째수 {

    /*
     * 시간 복잡도 : O(M * nlog(n))
     * 공간 복잡도 : O(N) : commands의 길이만큼 원소를 저장
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        for(int[] command : commands){
            int start = command[0] - 1;
            int end = command[1];
            int target = command[2] - 1;

            int[] targetArray = new int[end - start];
            int index = 0;
            for(int i = start; i < end; i++){
                targetArray[index++] = array[i];
            }
            Arrays.sort(targetArray);

            answer[answerIndex++] = targetArray[target];

        }
        return answer;
    }
}
