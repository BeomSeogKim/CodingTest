package codingsense._03_누적합;

import java.util.Scanner;

public class BOJ_1912 {
    static int[] arr;
    static int[] prefix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        arr = new int[n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 2; i < n + 1 ; i++) {
            prefix[i] = Math.max(prefix[i - 1] + arr[i - 1], arr[i - 1]);    // 최대값만 저장
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, prefix[i]);
        }
        System.out.println(max);
    }
}
