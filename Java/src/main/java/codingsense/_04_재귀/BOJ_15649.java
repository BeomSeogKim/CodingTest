package codingsense._04_재귀;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class BOJ_15649 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N];
        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                recursion(depth + 1);
                visited[i] = false;
            }
        }
    }

}