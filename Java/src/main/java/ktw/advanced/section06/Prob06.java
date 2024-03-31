package ktw.advanced.section06;

class Prob06 {
    int answer;
    boolean[] visited;
    public int solution(String s){
        answer = 0;
        visited = new boolean[s.length()];
        DFS(0, s);
        return answer;
    }

    private void DFS(int start, String s) {
        if (start == s.length()) {
            answer++;
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.substring(start).startsWith("0")) {
                    return;
                }
                if (Integer.parseInt(s.substring(start, i + 1)) <= 26 && !visited[i]) {
                    visited[i] = true;
                    DFS(i + 1, s);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Prob06 T = new Prob06();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}