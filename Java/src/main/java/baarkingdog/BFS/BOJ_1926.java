package baarkingdog.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1926 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문 하지 않았으며 그려져 있는 경우
                if (!visited[i][j] && arr[i][j] == 1) {
                    bfs(i,j);
                    number++;
                }
            }
        }

        System.out.println(number);
        System.out.println(max);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 0;
        while (!queue.isEmpty()) {
            area++;
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            for (int d = 0; d < dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            max = Math.max(max, area);
        }
    }
}
