package ktw.basic.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
3. 매출액의 종류
설명

현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를

각 구간별로 구하라고 했습니다.

만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면

20 12 20 10 23 17 10

각 연속 4일간의 구간의 매출종류는

첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.

두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.

세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.

네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.

N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별

매출액의 종류를 출력하는 프로그램을 작성하세요.


입력

첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


출력

첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.

 */
public class _03_매출액의종류 {

    public static void main(String[] args) {
        _03_매출액의종류 a03매출액의종류 = new _03_매출액의종류();
        Scanner kb=new Scanner(System.in);
        int tl = kb.nextInt();
        int l = kb.nextInt();
        int[] numbers = new int[tl];
        for (int i = 0; i < tl; i++) {
            numbers[i] = kb.nextInt();
        }
        for (Integer answer : a03매출액의종류.solution(tl, l, numbers)) {
            System.out.print(answer + " ");
        }

    }

    /*
    Sliding window 기법으로 문제 해결
    처음에 rt가 되기전까지만 순회하며 초기화
    그 후에 Sliding window로 size만큼을 answer에 넣는다.

     */
    private ArrayList<Integer> solution(int tl, int l, int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        // rt 전 까지 HashMap 초기화
        for (int i = 0; i < l - 1; i++) {
            HM.put(numbers[i], HM.getOrDefault(numbers[i], 0) + 1);
        }

        // Sliding Window
        int lt = 0;

        for (int rt = l - 1; rt < tl; rt++) {
            // rt 추가
            HM.put(numbers[rt], HM.getOrDefault(numbers[rt], 0) + 1);

            // 정답 추가
            answer.add(HM.size());

            // lt 삭제
            HM.put(numbers[lt], HM.get(numbers[lt]) - 1);

            // HashMap의 값이 0 일 경우 HashMap에서 삭제
            if (HM.get(numbers[lt]) == 0) {
                HM.remove(numbers[lt]);
            }
            lt++;
        }

        return answer;
    }


}

