package codingsense._04_재귀;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        recursion(0, 0 );

        System.out.println(sb);
    }

    private static void recursion(int depth, int startIndex) {
        if (depth == M) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = startIndex; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                recursion(depth + 1, i+ 1);
                visited[i] = false;
            }
        }
    }
}
