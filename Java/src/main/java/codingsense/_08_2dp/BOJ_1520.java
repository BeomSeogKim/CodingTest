package codingsense._08_2dp;

import java.util.Scanner;

public class BOJ_1520 {

    static int M, N;
    static int[][] map;
    static Integer[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        dp = new Integer[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(0, 0));
    }

    private static int solution(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (map[nx][ny] < map[x][y]) {
                    count += solution(nx, ny);
                }
            }
        }
        dp[x][y] = count;
        return dp[x][y];
    }
}
