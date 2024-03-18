package codingsense._08_2dp;

import java.util.Scanner;

public class BOJ_1937 {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution(i, j);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(dp[i][j], result);
            }
        }
        System.out.println(result + 1);
    }

    private static int solution(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arr[nx][ny] > arr[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], solution(nx,ny) + 1);
                }
            }
        }
        return dp[x][y];
    }
}
