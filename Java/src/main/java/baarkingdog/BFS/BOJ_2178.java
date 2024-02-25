package baarkingdog.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {

    static int[][] arr;
    static int[][] visited;
    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{-1, 0, 0, 1};
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // Initializing
        arr = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String numbers = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = numbers.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(visited[N - 1][M - 1]);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = 1;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            if (x == N - 1 && y == M - 1) {

            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 방문 안했는데 경로인경우
                    if (visited[nx][ny] == 0 && arr[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                }
            }
        }
    }
}
