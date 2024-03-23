package codingsense.복습;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14501 {
    static int N;
    static int[][] chart;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chart = new int[N][N];
        for (int i = 0; i < N; i++) {
            chart[i][0] = sc.nextInt();
            chart[i][1] = sc.nextInt();
        }
        dp = new int[N];
        Arrays.fill(dp, -1);

        System.out.println(solution(0));

    }

    private static int solution(int index) {
        if (index > N - 1) {
            return Integer.MIN_VALUE;
        }
        if (index == N - 1) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = Math.max(solution(index + 1), solution(index + chart[index][0]) + chart[index][1]);
        return dp[index];
    }
}
