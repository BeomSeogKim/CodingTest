package codingsense._04_재귀;

import java.util.Scanner;

public class BOJ_15650 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        recursion(0, 1);
        System.out.println(sb);
    }

    private static void recursion(int depth, int startNum) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            return;
        }
        for (int i = startNum; i <= N; i++) {
                arr[depth] = i ;
                recursion(depth + 1, i + 1);
        }
    }
}
