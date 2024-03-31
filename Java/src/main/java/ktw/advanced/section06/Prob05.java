package ktw.advanced.section06;

import java.util.*;

class Prob05 {
    LinkedList<String> tList;
    List<String> answer;

    public String[] solution(String s){
        tList = new LinkedList<>();
        answer = new ArrayList<>();
        DFS(0, s);
        return answer.toArray(new String[0]);
    }

    private void DFS(int start, String s) {
        if (tList.size() == 4 && start == s.length()) {
            String string = "";
            for (String st : tList) {
                string += st + ".";
            }
            answer.add(string.substring(0, string.length() - 1));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) {
                    return;
                }
                int num = Integer.parseInt(s.substring(start, i + 1));
                if (num > 255) {
                    return;
                }
                tList.add(String.valueOf(num));
                DFS(i + 1, s);
                tList.pollLast();
            }
        }
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