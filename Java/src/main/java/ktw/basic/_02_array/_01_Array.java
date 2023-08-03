package ktw.basic._02_array;

import java.util.ArrayList;
import java.util.Scanner;

/*
설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)


입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.


예시 입력 1

6
7 3 9 5 6 12
예시 출력 1

7 9 6 12
 */
public class _01_Array {
    public static void main(String[] args) {
        _01_Array _01_array = new _01_Array();
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();
        int[] intArray = new int[size];

        for (int i = 0; i < size; i++) {
            intArray[i] = kb.nextInt();
        }

        for (int i : _01_array.solution(intArray)) {
            System.out.print(i + " ");
        }
    }

    private ArrayList<Integer> solution(int[] intArray) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(intArray[0]);
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i - 1] < intArray[i]) {
                arrayList.add(intArray[i]);
            }
        }
        return arrayList;
    }
}
