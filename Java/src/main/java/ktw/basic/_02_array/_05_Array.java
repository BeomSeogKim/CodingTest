package ktw.basic._02_array;

import java.util.Scanner;

/*
설명

자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


출력
첫 줄에 소수의 개수를 출력합니다.


예시 입력 1

20
예시 출력 1

8
 */
public class _05_Array {
    public static void main(String[] args) {
        _05_Array a05Array = new _05_Array();
        Scanner kb = new Scanner(System.in);
        int number = kb.nextInt();

        System.out.println(a05Array.solution(number));

    }

    /*
    에라토스테네스 체 문제의 경우 소수 판별을 간단하게 하자.
    낮은 값을 토대로 차례로 값을 올라가면서 주어진 숫자 전까지는 체크를 해주는 방식
    ex) 2 => 2, 4 (2 + 2), 6 (2 + 2 + 2) ...
     */
    private int solution(int number) {
        int answer = 0;
        int[] ch = new int[number + 1];

        for (int i = 2; i < number; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = 0; j < number; j = j + i) {
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }
}
