package ktw.basic._01_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
4. 단어 뒤집기
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


예시 입력 1

3
good
Time
Big
예시 출력 1

doog
emiT
giB
 */
public class _04_String {
    public static void main(String[] args) {
        _04_String a04String = new _04_String();
        Scanner kb = new Scanner(System.in);
        int number = kb.nextInt();
        String[] words = new String[number];
        for (int i = 0; i < number; i++) {
            words[i] = kb.next();
        }
        List<String> results = a04String.solution(number, words);
        for (String result : results) {
            System.out.println(result);
        }

    }

    /*
    StringBuilder.reverse() => 단어를 뒤집어 준다.
     */
    private List<String> solution(int number, String[] words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            result.add(new StringBuilder(word).reverse().toString());
        }
        return result;
    }

    // lt, rt를 사용한 풀이
    private List<String> solution2(int number, String[] words) {
        ArrayList<String> result = new ArrayList<>();
        for(String word : words) {
            char[] charArray = word.toCharArray();
            int lt = 0;
            int rt = word.length() - 1;
            while (lt < rt) {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
            result.add(String.valueOf(charArray));
        }
        return result;
    }
}
