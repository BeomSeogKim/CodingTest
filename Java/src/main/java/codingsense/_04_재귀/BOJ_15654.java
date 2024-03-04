package codingsense._04_재귀;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
    static StringBuilder sb = new StringBuilder();
    static Integer[] arr;
    static boolean[] visited;
    static Integer[] answer;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new Integer[N];
        answer = new Integer[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(int depth) {
        if (depth == M) {
            for (int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                recursion(depth + 1);
                visited[i] = false;
            }
        }
    }
}
