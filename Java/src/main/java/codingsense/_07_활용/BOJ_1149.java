package codingsense._07_활용;

import java.util.Scanner;

public class BOJ_1149 {
    static int[][] infos;
    static int[][] dp;
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        infos = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                infos[i][j] = sc.nextInt();
            }
        }

        // Initializing
        dp[0][RED] = infos[0][RED];
        dp[0][GREEN] = infos[0][GREEN];
        dp[0][BLUE] = infos[0][BLUE];

        System.out.println(Math.min(solution(n - 1, RED), Math.min(solution(n - 1, GREEN), solution(n - 1, BLUE))));

    }

    private static int solution(int depth, int color) {
        if (dp[depth][color] == 0) {
            if (color == RED) {
                dp[depth][color] = Math.min(solution(depth - 1, GREEN), solution(depth - 1, BLUE)) + infos[depth][color];
            } else if (color == GREEN) {
                dp[depth][color] = Math.min(solution(depth - 1, RED), solution(depth - 1, BLUE)) + infos[depth][color];
            } else {
                dp[depth][color] = Math.min(solution(depth - 1, RED), solution(depth - 1, GREEN)) + infos[depth][color];
            }
        }
        return dp[depth][color];
    }
}
