package ktw.advanced.section07;

import java.util.LinkedList;
import java.util.Queue;

class Prob04 {

    Integer[][] arr;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int[][] board){
        arr = new Integer[board.length][board[0].length];
        BFS(0, 0, board);
        return arr[board.length - 1][board[0].length - 1] == null ? -1 : arr[board.length - 1][board[0].length - 1];
    }

    private void BFS(int row, int col, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        arr[0][0] = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                        if (arr[nx][ny] == null && board[nx][ny] == 0) {
                            queue.add(new int[]{nx, ny});
                            arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Prob04 T = new Prob04();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
