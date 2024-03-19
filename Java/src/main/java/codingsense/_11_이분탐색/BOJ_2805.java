package codingsense._11_이분탐색;

import java.util.Scanner;

public class BOJ_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];
        int p2 = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            p2 = Math.max(p2, num);
            trees[i] = num;
        }

        int p1 = 0;
        while (p1 <= p2) {
            int mid = (p1 + p2) / 2;
            long sum = 0;
            for (long tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }
            if (sum >= M) {
                p1 = mid + 1;
            } else {
                p2 = mid - 1;
            }
        }
        System.out.println(p2);
    }
}
