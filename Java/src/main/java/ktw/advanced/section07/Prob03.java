package ktw.advanced.section07;

import java.util.LinkedList;
import java.util.Queue;

class Prob03 {

    boolean[][] visited;

    public int solution(int s, int e) {
        visited = new boolean[200001][2];

        return BFS(s, e);
    }

    private int BFS(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s][0] = true;

        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                for (int nx : new int[]{cur - 1, cur + 1, cur * 2}) {
                    if (nx >= 0 && nx < 200001 && !visited[nx][level % 2]) {
                        visited[nx][level % 2] = true;
                        queue.offer(nx);
                    }
                }
            }
            e += level;
            if (e >= 200000) {
                return -1;
            }
            if (visited[e][level % 2]) {
                return level;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob03 T = new Prob03();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
