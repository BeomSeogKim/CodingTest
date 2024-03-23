package codingsense.복습;

import java.util.Scanner;

public class BOJ_12865 {
    static int N, K;
    static int[][] bags;
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        bags = new int[N][2];
        dp = new Integer[N][K + 1];
        for (int i = 0; i < N; i++) {
            bags[i][0] = sc.nextInt();
            bags[i][1] = sc.nextInt();
        }
        System.out.println(solution(N - 1, K));;
    }

    static int solution(int i, int k) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][k] == null) {
            if (bags[i][0] > k) {
                dp[i][k] = solution(i - 1, k);
            } else {
                dp[i][k] = Math.max(solution(i - 1, k), solution(i - 1, k - bags[i][0]) + bags[i][1]);
            }
        }
        return dp[i][k];

    }
}
