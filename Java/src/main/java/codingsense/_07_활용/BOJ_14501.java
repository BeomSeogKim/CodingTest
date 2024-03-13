package codingsense._07_활용;

import java.util.Scanner;

public class BOJ_14501 {
    static int[][] chart;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        chart = new int[n][2];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            chart[i][0] = sc.nextInt();
            chart[i][1] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + chart[i][0] >= n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + chart[i][0]]+ chart[i][1], dp[i + 1]);
            }
        }
        System.out.println(dp[0]);
    }
}
