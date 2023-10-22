package programmers.online.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 문제 관련 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * 간단 설명 : 2차원 배열로 옷들이 주어졌을 때, 서로 다른 옷의 조합의 수를 return 하라.
 * 조건
 * * 각 종류별로 최대 1가지의 의상만 착용이 가능하다.
 * * 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 추가로 더 착용한 경우는 유효하다.
 * * 하루에 최소 한개의 의상은 입는다.
 */
public class _04_의상 {

    /*
     * 시간 복잡도 : O(N) : 2차원 배열의 개수만큼 순회
     * 공간 복잡도 : O(N) : 옷의 종류만큼 map에 저장.
     */
    class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();
            for(String[] clothe : clothes){
                String category = clothe[1];
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int answer = 1;

            /*
            해당 부분의 경우 iterator로도 활용이 가능하다.
             */
            for(String key : map.keySet()){
                answer *= ( map.get(key) + 1 );
            }

//            Iterator<Integer> iterator = map.values().iterator();
//            while (iterator.hasNext()) {
//                answer *= (iterator.next().intValue() + 1);
//            }

            return answer - 1;
        }
    }
}
