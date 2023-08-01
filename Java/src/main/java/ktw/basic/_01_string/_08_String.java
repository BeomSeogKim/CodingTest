package ktw.basic._01_string;

import java.util.Scanner;

public class _08_String {

    public static void main(String[] args) {
        _08_String _08_string = new _08_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.nextLine();
        System.out.println(_08_string.solution(word));
    }

    /*
    정규 표현식을 사용해서 문자가 아닌 것들은 없애기
    ^ 부정
    [^A-Z] => 영어 대문자가 아닌 것들
     */
    private String solution(String word) {
        word = word.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseString = new StringBuilder(word).reverse().toString();
        if (word.equals(reverseString)) {
            return "YES";
        }
        return "NO";
    }
}
