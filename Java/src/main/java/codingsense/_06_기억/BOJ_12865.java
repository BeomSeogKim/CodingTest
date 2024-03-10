package codingsense._06_기억;

import java.util.Scanner;

public class BOJ_12865 {

    static int N;
    static int K;
    static int[][] merchandise; // 0 : 무게, 1 : 가치
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        merchandise = new int[N][2];
        dp = new int[10000000][N];
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            merchandise[i][0] = sc.nextInt();
            merchandise[i][1] = sc.nextInt();
        }

        int max = recursion(0, 0);
        System.out.println(max);
    }

    private static int recursion(int index, int weight) {
        if (weight > K) {
            return Integer.MIN_VALUE;
        }
        if (index == N) {
            return 0;
        }
        if (dp[weight][index] != -1) {
            return dp[weight][index];
        }
        dp[weight][index] = Math.max(recursion(index + 1, weight), recursion(index + 1, weight + merchandise[index][0]) + merchandise[index][1]);

        return dp[weight][index];
    }
}
