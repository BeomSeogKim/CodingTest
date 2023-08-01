package ktw.basic._01_string;

import java.util.Scanner;

/*
설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는

문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.

단 반복횟수가 1인 경우 생략합니다.


입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


출력
첫 줄에 압축된 문자열을 출력한다.


예시 입력 1
KKHSSSSSSSE
예시 출력 1
K2HS7E
예시 입력 2
KSTTTSEEKFKKKDJJGG
예시 출력 2
KST3SE2KFK3DJ2G2
 */
public class _11_String {

    public static void main(String[] args) {
        _11_String a11String = new _11_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        System.out.println(a11String.solution(word));
    }

    private String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        char prev = word.charAt(0);
        int count = 1;

        stringBuilder.append(prev);

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == prev) {
                count++;
            } else {
                if (count != 1) {
                    stringBuilder.append(count);
                }
                count = 1;
                stringBuilder.append(word.charAt(i));
                prev = word.charAt(i);
            }
        }
        if (count != 1) {
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }

    private String solution2(String word) {
        String answer = "";
        word = word + " ";
        int cnt = 1;

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) cnt ++;
            else {
                answer += word.charAt(i);
                if (cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return answer;
    }
}
