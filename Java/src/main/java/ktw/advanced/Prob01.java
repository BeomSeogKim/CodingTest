package ktw.advanced;

import java.util.HashMap;
import java.util.Map;

class Prob01 {
    public int solution(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //charAt 메서드를 잘 활용할 수 있도록!
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Prob01 T = new Prob01();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
