package ktw.basic.hashmap_treeset;

import java.util.HashMap;
import java.util.Scanner;
/*
설명

Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.

예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로

알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.

길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.


입력
첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.

단어의 길이는 100을 넘지 않습니다.


출력
두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.

예시 입력
AbaAeCe
baeeACA

예시 출력
YES

예시 입력
abaCC
Caaab

예시 출력
NO
 */

/*
검증을 할 때 key에 값이 존재하지 않거나, 0인 경우 바로 return
그 외의 경우 hashmap.put( , )으로 해결
HashMap의 경우 put을 하게 되면 기존의 값을 대치해주는 효과를 지닌다.
 */

public class _02_Anagram {

    public static void main(String[] args) {
        _02_Anagram a02Anagram = new _02_Anagram();

        Scanner kb=new Scanner(System.in);
        String word1 = kb.next();
        String word2 = kb.next();
        System.out.println(a02Anagram.solution(word1, word2));

    }


    /*
    시간 복잡도 : O(N)
    공간 복잡도 : O(K) -> HashMap에 들어가는 키 값
     */
    private String solution(String word1, String word2) {
        HashMap<Character, Integer> wordHashMap = new HashMap<>();

        for (char c : word1.toCharArray()) {
            wordHashMap.put(c, wordHashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            if (wordHashMap.containsKey(c)) {
                Integer resNum = wordHashMap.get(c);
                if (resNum == 1) {
                    wordHashMap.remove(c);
                } else {
                    wordHashMap.replace(c, resNum - 1);
                }
            } else {
                return "NO";
            }
        }
        return "YES";
    }

    private String solution2(String word1, String word2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return answer;
    }
}
