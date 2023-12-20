package ktw.basic._01_String;

import java.util.Scanner;

/*
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요
 */
public class _02_대소문자변환 {

    private void solution(String target) {
        StringBuilder sb = new StringBuilder();
        for (char word : target.toCharArray()) {
            if (Character.isUpperCase(word)) {
                sb.append(String.valueOf(word).toLowerCase());
            } else {
                sb.append(String.valueOf(word).toUpperCase());
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        _02_대소문자변환 prob = new _02_대소문자변환();
        Scanner sc = new Scanner(System.in);
        String target = sc.next();

        prob.solution(target);
    }
}
