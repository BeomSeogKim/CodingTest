package codingsense._03_누적합;

import java.util.Scanner;

public class BOJ_2559 {
    static int[] arr;
    static int[] prefix;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Initializing Array
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Initialize prefix
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

//         get solution
        for (int i = k; i < n + 1; i++) {
            int diff = prefix[i] - prefix[i - k];
            max = Math.max(max, diff);
        }

        System.out.println(max);
    }
}
