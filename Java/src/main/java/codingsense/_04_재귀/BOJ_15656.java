package codingsense._04_재귀;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15656 {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        recursion(0, 0);
        System.out.println(sb);
    }

    private static void recursion(int depth, int index) {
        if (depth == M) {
            for (int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            answer[depth] = arr[i];
            recursion(depth + 1, i);
        }
    }
}
