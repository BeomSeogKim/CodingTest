package ktw.basic._01_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
6. 중복문자제거
설명

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.

중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.


예시 입력 1

ksekkset
예시 출력 1

kset
 */
public class _06_String {
    public static void main(String[] args) {
        _06_String a06String = new _06_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();
        System.out.println(a06String.solution2(word));
    }

    /*
    시간 복잡도 : O(N)
    공간 복잡도 : O(K) => K : unique 값들
     */
    private String solution(String word) {
        char[] charArray = word.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (!characters.contains(charArray[i])) {
                characters.add(charArray[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : characters) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /*
    indexOf 의 경우 가장 먼저나오는 char의 index를 반환한다.
    => 먼저 나온 char이 아닌 경우 indexOf의 값과 i 값이 다름

    시간 복잡도 : O(N^2) => indexOf의 경우 최악의 시간 복잡도 O(N)
    공간 복잡도 : O(N) => StringBuilder에 N개의 문자가 생성 될 수 있으므로
     */
    private String solution2(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i)) == i) {
                stringBuilder.append(word.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


}
