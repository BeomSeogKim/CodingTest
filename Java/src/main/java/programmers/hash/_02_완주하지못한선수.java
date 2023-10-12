package programmers.hash;

import java.util.HashMap;
import java.util.Map;

/*
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
 * 문제 설명 : 마라톤에 참여한 선수들에 대해 참가자는 participant, 완주자는 completion에 담긴다고 할 때, 완주하지 못한 선수를 return 하는 문제
 *
 * 시간 복잡도 : O(N) => participant의 수 만큼
 * 공간 복잡도 : O(N) => participant의 수 만큼

 */
public class _02_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // participant 순회
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // completion 순회
        for(String c : completion){
            Integer numberOfPeople = map.get(c);
            if (numberOfPeople == 1){   // 만약 참가자가 한명만 있다면 map에서 제거하자.
                map.remove(c);
            } else {
                map.put(c, numberOfPeople - 1); // map의 경우 put을 하면 덮어쓸 수 있다.
            }
        }

        return map.keySet().iterator().next();  // keySet을 iterator를 통해 반복 가능하게끔 변경 후 next()를 통해서 들고오기
    }
}
