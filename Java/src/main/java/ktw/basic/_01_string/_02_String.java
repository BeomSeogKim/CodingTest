package ktw.basic._01_string;

import java.util.Scanner;

/*
Char과 관련한 문법
* 소문자 체크 : Character.isLowerCase()
* 대문자 체크 : Character.isUpperCase()
* 소문자 변환 : Character.toLowerCase()
* 대문자 변환 : Character.toUpperCase()
 */
public class _02_String {

    public static void main(String[] args) {
        _02_String string = new _02_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        System.out.println(string.solution(word));

    }

    private String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        String upperCase = word.toUpperCase();
        String lowerCase = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == upperCase.charAt(i)) {
                stringBuilder.append(lowerCase.charAt(i));
            } else {
                stringBuilder.append(upperCase.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private String solution2(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }

    /*
    ASCII 를 활용한 풀이
     */
    private String solution3(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            if (c >= 97 && c <= 122) {   // 소문자
                answer += (c - 32);     // 소문자 -> 대문자
            } else {
                answer += (c + 32);
            }
        }
        return answer;
    }
}
