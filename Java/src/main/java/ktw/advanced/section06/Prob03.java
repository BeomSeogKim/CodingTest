package ktw.advanced.section06;

class Prob03 {

    int answer, L, mid;
    boolean[] visited;
    int[][] arr;

    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        L = cans.length;
        mid = L / 2;
        visited = new boolean[L];
        arr = cans;

        DFS(0, 0);
        return answer;
    }

    private void DFS(int length, int lastIndex) {
        if (length == mid) {
            int sumWhite = 0;
            int sumBlack = 0;
            for (int i = 0; i < L; i++) {
                if (visited[i]) {
                    sumWhite += arr[i][0];
                } else {
                    sumBlack += arr[i][1];
                }
            }
            answer = Math.min(answer, Math.abs(sumWhite - sumBlack));
        } else {
            for (int i = lastIndex; i < L; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(length + 1, lastIndex + 1);
                    visited[i] = false;
                }
            }
        }
    }


    public static void main(String[] args){
        Prob03 T = new Prob03();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}