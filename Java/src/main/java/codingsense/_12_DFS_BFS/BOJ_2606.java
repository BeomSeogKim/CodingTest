package codingsense._12_DFS_BFS;

import java.util.*;

public class BOJ_2606 {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computerNum = sc.nextInt();
        int infoNum = sc.nextInt();

        graph = new int[computerNum + 1][computerNum + 1];
        visited = new boolean[computerNum + 1];
        for (int i = 0; i < infoNum; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        recursion(1);

        int result = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                result++;
            }
        }
        System.out.println(result - 1); // 1번 노드는 제외
    }

    static void recursion(int nodeNum) {
        visited[nodeNum] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[nodeNum][i] == 1 && !visited[i]) {
                recursion(i);
            }
        }
    }

    private static void bfs(int nodeNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nodeNum);

        while (!queue.isEmpty()) {
            Integer currentNum = queue.poll();
            visited[currentNum] = true;
            for (int i = 0; i < graph.length; i++) {
                if (graph[currentNum][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }
}
