package ktw.basic.hashmap_treeset;

import java.util.HashMap;
import java.util.Scanner;
/*
4. 모든 아나그램 찾기
설명

S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


예시 입력 1

bacaAacba
abc
예시 출력 1

3
힌트

출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 */

public class _04_모든_아나그램_찾기 {

    public static void main(String[] args) {
        _04_모든_아나그램_찾기 a04모든아나그램찾기 = new _04_모든_아나그램_찾기();

        Scanner kb=new Scanner(System.in);
        String word1 = kb.next();
        String word2 = kb.next();
        System.out.println(a04모든아나그램찾기.solution(word1, word2));

    }


    /*
    시간 복잡도 : O(N)
    공간 복잡도 : O(K) -> HashMap에 들어가는 키 값
     */
    private int solution(String word1, String word2) {
        int answer = 0;
        HashMap<Character, Integer> HM1 = new HashMap<>();
        HashMap<Character, Integer> HM2 = new HashMap<>();

        // word 2 초기화
        for (char c : word2.toCharArray()) {
            HM2.put(c, HM2.getOrDefault(c, 0) + 1);
        }

        // word 1 초기 setting
        for (int i = 0; i < word2.length() - 1; i++) {
            char c = word1.charAt(i);
            HM1.put(c, HM1.getOrDefault(c, 0) + 1);
        }

        // Sliding Window
        int lt = 0;
        for (int rt = word2.length() - 1; rt < word1.length(); rt++) {
            char c = word1.charAt(rt);
            HM1.put(c, HM1.getOrDefault(c, 0) + 1);
            if (HM1.equals(HM2)) {
                answer++;
            }
            HM1.put(word1.charAt(lt), HM1.get(word1.charAt(lt)) - 1);
            if (HM1.get(word1.charAt(lt)) == 0) {
                HM1.remove(word1.charAt(lt));
            }
            lt++;
        }
        return answer;
    }

}
