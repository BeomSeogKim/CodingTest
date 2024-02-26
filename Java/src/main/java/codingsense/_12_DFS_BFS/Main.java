package codingsense._12_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    // 육지 : L , 바다 : W
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        graph = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String info = sc.next();
            for (int col = 0; col < cols; col++) {
                graph[row][col] = info.charAt(col);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (graph[row][col] == 'L') {
                    visited = new boolean[rows][cols];
                    dist = new int[rows][cols];
                    bfs(row, col);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()){
            int[] info = queue.poll();
            int curR = info[0];
            int curC = info[1];
            for (int i = 0; i < 4; i++) {
                int newR = curR + dx[i];
                int newC = curC + dy[i];
                if (newR >= 0 && newR < graph.length && newC >= 0 && newC < graph[0].length) {
                    if (!visited[newR][newC] && graph[newR][newC] == 'L') {
                        visited[newR][newC] = true;
                        dist[newR][newC] = dist[curR][curC] + 1;
                        max = Math.max(max, dist[newR][newC]);
                        queue.offer(new int[]{newR, newC});
                    }
                }
            }
        }
    }
}
