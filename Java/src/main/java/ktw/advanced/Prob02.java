package ktw.advanced;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob02 {
    char[] charArray = {'a', 'b', 'c', 'd', 'e'};
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            max = Math.max(max, count);
            map.put(c, count);
        }

        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (map.containsKey(charArray[i])) {
                answer[i] = max - map.get(charArray[i]);
            } else {
                answer[i] = max;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob02 T = new Prob02();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

}
