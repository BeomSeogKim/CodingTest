package ktw.basic._01_String;

import java.util.Scanner;

/*
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 */
public class _01_문자찾기 {
    public static void main(String[] args) {
        _01_문자찾기 prob = new _01_문자찾기();

        Scanner kb = new Scanner(System.in);
        String target = kb.nextLine();
        String counter = kb.nextLine();

        prob.solution(target, counter);
    }

    private void solution(String target, String counter) {
        int count = 0;
        for (char c : target.toUpperCase().toCharArray()) {
            if (c == counter.toUpperCase().charAt(0)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
