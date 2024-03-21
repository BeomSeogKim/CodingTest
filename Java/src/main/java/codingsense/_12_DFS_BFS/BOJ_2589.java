package codingsense._12_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2589 {

    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        char[][] arr = new char[M][N];
        for (int i = 0; i < M; i++) {
            String string = sc.next();
            char[] charArray = string.toCharArray();
            for (int j = 0; j < string.length(); j++) {
                arr[i][j] = charArray[j];
            }
        }

        boolean[][] visited;
        int[][] distance;
        int maxDistance = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[M][N];
                    distance = new int[M][N];
                    visited[i][j] = true;
                    distance[i][j] = 0;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] points = queue.poll();
                        int x = points[0];
                        int y = points[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] == 'L' && !visited[nx][ny]) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                distance[nx][ny] = distance[x][y] + 1;
                                maxDistance = Math.max(distance[nx][ny], maxDistance);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(maxDistance);

    }
}
