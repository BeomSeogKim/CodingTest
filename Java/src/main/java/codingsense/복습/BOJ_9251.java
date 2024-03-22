package codingsense.복습;

import java.util.Scanner;

public class BOJ_9251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string1 = sc.next();
        String string2 = sc.next();
        char[] arr1 = string1.toCharArray();
        char[] arr2 = string2.toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
    }
}
