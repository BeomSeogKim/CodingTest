package ktw.advanced;

import java.util.*;

class Prob03 {
    public int solution(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
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
