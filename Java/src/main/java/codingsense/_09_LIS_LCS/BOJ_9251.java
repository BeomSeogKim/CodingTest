package codingsense._09_LIS_LCS;

import java.util.Scanner;

/**
 * LCS : 문자의 끝을 기준으로 판단하면 되는 문제
 * if 문자열의 끝이 간다면
 * LCS(M,N) = LCS(M[:-1], N[:-1]) + 1
 * else
 * LCS(M,N) = max(LCS(M, N[:-1]), LCS(M[:-1], N))
 */
public class BOJ_9251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
