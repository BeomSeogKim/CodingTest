package codingsense._07_활용;

import java.util.Scanner;

public class BOJ_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 무게
        int k = sc.nextInt();   // 가치

        int[][] products = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            products[i][0] = sc.nextInt();
            products[i][1] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (products[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - products[i][0]] + products[i][1]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}

