package ktw.basic._01_String;

import java.util.Scanner;

/*
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 */
public class _03_문장속단어 {

    private void solution(String sentence) {
        String answer = "";
        int m = Integer.MIN_VALUE;

        String[] s = sentence.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }
        System.out.println(answer);
    }

    private void solution2(String sentence) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = sentence.indexOf(' ')) != -1) {   // indexOf의 경우 만족하는 값이 없을 때 -1 return
            String tmp = sentence.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            sentence = sentence.substring(pos + 1);
        }
        if (sentence.length() > m ) answer = sentence;

        System.out.println(answer);
    }

    public static void main(String[] args) {
        _03_문장속단어 main = new _03_문장속단어();
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        main.solution2(sentence);
    }
}
