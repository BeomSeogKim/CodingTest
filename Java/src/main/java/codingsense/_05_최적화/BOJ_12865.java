package codingsense._05_최적화;

import java.util.Scanner;

public class BOJ_12865 {

    static int N;
    static int K;

    static int answer = Integer.MIN_VALUE;
    static int[][] products;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        products = new int[N][2];
        for (int i = 0; i < N; i++) {
            products[i][0] = sc.nextInt();
            products[i][1] = sc.nextInt();
        }

        recursion(0,0, 0);

        System.out.println(answer);
    }

    private static void recursion(int index, int weight, int value) {
        if (weight > K) {
            return;
        }
        if (index == N) {
            answer = Math.max(answer, value);
            return;
        }
        recursion(index + 1, weight, value);
        recursion(index + 1, weight + products[index][0], value + products[index][1]);

    }
}
