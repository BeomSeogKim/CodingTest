package ktw.basic._02_array;

import java.util.ArrayList;
import java.util.Scanner;

/*
설명
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.

가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


예시 입력 1
5
2 3 3 1 3
1 1 2 2 3
예시 출력 1
A
B
A
B
D
 */
public class _03_Array {

    public static void main(String[] args) {
        _03_Array a03Array = new _03_Array();
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = kb.nextInt();
        }
        for (int i = 0; i < size; i++) {
            b[i] = kb.nextInt();
        }

        for (String s : a03Array.solution(a, b)) {
            System.out.println(s);
        }

    }

    private ArrayList<String> solution(int[] a, int[] b) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            // 비기는 경우
            if (a[i] == b[i]) {
                answer.add("D");
            } else if (
                    (a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)) {
                answer.add("A");
            } else {
                answer.add("B");
            }
        }
        return answer;
    }
}
