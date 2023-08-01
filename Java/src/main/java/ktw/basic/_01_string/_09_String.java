package ktw.basic._01_string;

import java.util.Scanner;

/*
설명
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.

만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.

추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.


입력
첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.


출력
첫 줄에 자연수를 출력합니다.


예시 입력 1
g0en2T0s8eSoft
예시 출력 1
208
 */
public class _09_String {
    public static void main(String[] args) {
        _09_String a09String = new _09_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        System.out.println(a09String.solution(word));

    }

    /*
    String 을 Integer로 변환할 때 parseInt를 사용하자.
    Integer.valueOf => Integer 반환
    Integer.parseInt => int 반환
     */
    private int solution(String word) {
        word = word.replaceAll("[A-Za-z]", "");
        return Integer.parseInt(word);
    }

    /*
    문자 '0' : 48
    문자 '9' : 57
    48 ~ 57 => 숫자
     */
    private int solution2(String word) {
        int answer = 0;
        for (char c : word.toCharArray()) {
            if (c >= 48 && c <= 57) {
                answer = answer * 10 + (c - 48);
            }
        }
        return answer;
    }

    /*
    Character.isDigit() => char이 숫자인지 검증
     */
    private int solution3(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.parseInt(answer);
    }
}
