package codingsense._04_재귀;

import java.util.Scanner;

public class BOJ_15651 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        recursion(0);
        System.out.println(sb);
    }

    static void recursion(int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            recursion(depth + 1);
        }
    }
}
