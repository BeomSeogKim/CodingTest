package ktw.advanced.section06;

import java.util.*;
class Prob05 {
    String string;
    List<String> list;

    public String[] solution(String s){
        string = s;

        String[] answer = {};


        return answer;
    }

    public static void main(String[] args){
        Prob05 T = new Prob05();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}