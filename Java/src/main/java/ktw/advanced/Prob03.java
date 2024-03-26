package ktw.advanced;

import java.util.*;

class Prob03 {
    public int solution(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
        // idea
        // set 자료구조를 활용해 감소시켜야 하는 값을 측정 하기
        // set에 값이 없다면 그대로 넣어주고, 만약 있다면 0이 될 때 까지 1씩 내려서 체크
        // 0이 될 경우에는 set에 따로 넣지 않고 종료.
        Set<Integer> set = new HashSet<>();
        for (int number : map.values()) {
            while (set.contains(number) && number != 0) {
                answer++;
                number--;
            }
            if (number != 0) {
                set.add(number);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Prob03 T = new Prob03();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
