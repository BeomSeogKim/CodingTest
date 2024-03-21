package codingsense._12_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int c = sc.nextInt();
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < c; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            arr[c1][c2] = 1;
            arr[c2][c1] = 1;
        }

        bfs();
//        dfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int result = 0;
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[index][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs() {
        solution(1);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                result++;
            }
        }
        System.out.println(result - 1);
    }

    private static void solution(int index) {
        visited[index] = true;
        for (int i = 0; i < N; i++) {
            if (arr[index][i] == 1 && !visited[i]) {
                solution(i);
            }
        }
    }
}
