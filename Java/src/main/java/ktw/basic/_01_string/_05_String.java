package ktw.basic._01_string;

import java.util.Scanner;

/*
5. 특정 문자 뒤집기
설명

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


예시 입력 1

a#b!GE*T@S
예시 출력 1

S#T!EG*b@a
 */
public class _05_String {
    public static void main(String[] args) {
        _05_String a05String = new _05_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        System.out.println(a05String.solution(word));

    }

    /*
    Character.isAlphabetic() => char 이 alphabet 인지 검증 해주는 메서드
     */
    private String solution(String word) {
        char[] charArray = word.toCharArray();

        int lt = 0;
        int rt = word.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            }
            if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            }
            if (Character.isAlphabetic(charArray[lt]) && Character.isAlphabetic(charArray[rt])) {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(charArray);
    }

}
