package codingsense._09_LIS_LCS;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11053 {

    static int[] arr;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int count : dp) {
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
