package ktw.advanced.section07;

import java.util.LinkedList;
import java.util.Queue;

class Prob02 {

    boolean[][] visited;

    public int solution(int[] pool, int a, int b, int home){
        // 0 : forward, 1 : backward
        visited = new boolean[10001][2];

        // initializae pool
        for (int p : pool) {
            visited[p][0] = true;
            visited[p][1] = true;
        }

        return BFS(a, b, home);
    }

    private int BFS(int a, int b, int home) {
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        visited[0][1] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                if (cur[0] == home) {
                    return level;
                }
                int nx = cur[0] + a;
                if (nx <= 10001 && !visited[nx][0]) {
                    visited[nx][0] = true;
                    queue.offer(new int[]{nx, 0});
                }
                nx = cur[0] - b;
                if (nx >= 0 && !visited[nx][1] && cur[1] == 0) {
                    visited[nx][1] = true;
                    queue.offer(new int[]{nx, 1});
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        Prob02 T = new Prob02();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
