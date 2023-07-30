package ktw.basic._01_string;

import java.util.Scanner;

public class _07_String {

    public static void main(String[] args) {
        _07_String a07String = new _07_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        System.out.println(a07String.solution2(word));
    }

    /*
    시간복잡도 : O(N)
    공간복잡도 : O(1)
     */
    public String solution(String word) {
        int len = word.length();
        word = word.toLowerCase();

        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }

    /*
    String 의 경우 대소문자 비교를 하지 않고 값 자체만을 비교하려고 하는 경우 equalsIgnoreCase 를 사용
    시간 복잡도 O(N) => 문자열 뒤집기 O(N), 소문자 변환 O(N), 문자열 비교 O(N)
    공간 복잡도 O(N)
     */
    public String solution2(String word) {
        int len = word.length();
        String reverseString = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reverseString)) {
            return "YES";
        }
        return "NO";
    }

}
