package ktw.basic._02_array;

import java.util.ArrayList;
import java.util.Scanner;

/*
8. 등수구하기
설명

N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


입력
첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


출력
입력된 순서대로 등수를 출력한다.


예시 입력 1

5
87 89 92 100 76
예시 출력 1

4 3 2 1 5
 */
public class _08_Array {
    public static void main(String[] args) {
        _08_Array a08Array = new _08_Array();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = kb.nextInt();
        }
        ArrayList<Integer> answer = a08Array.solution(intArray);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    private ArrayList<Integer> solution(int[] intArray) {
        ArrayList<Integer> answer = new ArrayList<>();
        int size = intArray.length;
        for (int i = 0; i < size; i++) {
            int currentNum = intArray[i];
            int gradeNum = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    if (intArray[j] > currentNum) {
                        gradeNum++;
                    }
                }
            }
            answer.add(gradeNum);
        }
        return answer;
    }
}
