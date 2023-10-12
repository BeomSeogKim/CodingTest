package programmers.hash;

import java.util.HashMap;

/*
 * Link of problem ; https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
 * 문제 설명 : 여러가지 폰켓몬이 있을 때 (size : N), 최대 N / 2 개의 폰켓몬을 가져갈 수 있다.
 * 이럴 때 가능한 최대의 폰켓몬 종류 수를 return 하는 문제
 *
 * 시간 복잡도 : O(N) => nums 배열 순회 하는 로직
 * 공간 복잡도 : O(N) => map의 size 크기 만큼.
 */
public class _01_폰켓몬 {
    public int solution(int[] nums) {
        int halfNumber = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int unique = map.size();
        if (unique > halfNumber){
            return halfNumber;
        } else{
            return unique;
        }

    }
}
