package codingsense.복습;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_22988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long X = sc.nextLong();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long half;
        if (X % 2 == 0) {
            half = X / 2;
        } else {
            half = X / 2 + 1;
        }

        int p1 = 0;
        int p2 = N - 1;
        int count = 0;
        int resCount = 0;
        while (p1 < p2) {
            long res = arr[p1] + arr[p2];

            if (res >= half) {
                count++;
                p1++;
                p2--;
            } else {
                resCount++;
                p1++;
            }

        }

        System.out.println(count + resCount / 3);
    }
}
