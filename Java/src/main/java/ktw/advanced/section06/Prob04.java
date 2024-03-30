package ktw.advanced.section06;

import java.util.*;
class Prob04 {
    Set<String> answer;
    int L, mid;
    boolean[] visited;
    char[] charArray;
    public String[] solution(String s){
        answer = new HashSet<>();
        L = s.length();
        if (L % 2 == 0) {
            mid = L / 2;
        } else {
            mid = L / 2 + 1;
        }
        visited = new boolean[L];
        charArray = s.toCharArray();
        DFS(0, "");

        return answer.toArray(new String[0]);
    }

    private void DFS(int length, String string) {
        if (length == L) {
            // 팰린드롬 유효성 체크
            boolean isPalindrome = true;
            for (int i = 0; i < mid; i++) {
                if (string.charAt(i) != string.charAt(L - i - 1)) {
                    isPalindrome = false;
                }
            }
            if (isPalindrome) {
                answer.add(string);
            }
        } else {
            for (int i = 0; i < L; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(length + 1, string + charArray[i]);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Prob04 T = new Prob04();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}