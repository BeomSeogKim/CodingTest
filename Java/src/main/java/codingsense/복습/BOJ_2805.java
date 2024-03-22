package codingsense.복습;

import java.util.Scanner;

public class BOJ_2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 나무의 개수
        int M = sc.nextInt();   // 채취하고자 하는 양
        int[] trees = new int[N];
        int high = 0;
        for (int i = 0; i < N; i++) {
            int height = sc.nextInt();
            high = Math.max(high, height);
            trees[i] = height;
        }

        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }
            if (sum >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}
