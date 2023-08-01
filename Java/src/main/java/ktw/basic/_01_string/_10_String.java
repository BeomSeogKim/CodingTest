package ktw.basic._01_string;

import java.util.Scanner;

/*
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1
teachermode e
예시 출력 1
1 0 1 2 1 0 1 2 2 1 0
 */
public class _10_String {
    public static void main(String[] args) {
        _10_String a10String = new _10_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        String target = kb.next();
        for (int i : a10String.solution(word, target)) {
            System.out.print(i + " ");
        }

    }

    private int[] solution(String word, String target) {
        int[] answer = new int[word.length()];
        char c = target.charAt(0);
        int p = 1000;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p += 1;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
}
