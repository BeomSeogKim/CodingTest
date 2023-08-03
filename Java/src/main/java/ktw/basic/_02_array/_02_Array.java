package ktw.basic._02_array;

import java.util.ArrayList;
import java.util.Scanner;

/*
설명

선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


입력
첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


출력
선생님이 볼 수 있는 최대학생수를 출력한다.


예시 입력 1

8
130 135 148 140 145 150 150 153
예시 출력 1

5
 */
public class _02_Array {
    public static void main(String[] args) {
        _02_Array a02Array = new _02_Array();
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();
        int[] heights = new int[size];

        for (int i = 0; i < size; i++) {
            heights[i] = kb.nextInt();
        }

        System.out.println(a02Array.solution(heights));

    }

    private int solution(int[] heights) {
        int maxHeight = Integer.MIN_VALUE;
        ArrayList<Integer> heightList = new ArrayList<>();

        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
                heightList.add(height);
            }
        }

        return heightList.size();
    }

    private int solution2(int[] heights) {
        int answer = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
                answer++;
            }
        }

        return answer;
    }
}
