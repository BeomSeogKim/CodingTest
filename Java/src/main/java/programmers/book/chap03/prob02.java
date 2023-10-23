package programmers.book.chap03;

/*
 * 문제 흐름
 * n * n 2차원 배열 선언
 * 숫자를 채울 현재 위치를 (0,0)으로 설정
 * 방향에 따라 이동할 수 없을 때 까지 반복하면서 숫자 채우기
 * * A 아래로 이동하면서 숫자 채우기
 * * B 오른쪽으로 이동하면서 숫자 채우기
 * * C 왼쪽 위로 이동하면서 숫자 채우기
 * 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
 */
public class prob02 {

    /*
    Solution 1 : dx, dy를 사용하지 않고 작성한 solution
     */
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = v++;
                if (y + 1 == n || triangle[y+1][x]!=0) break;
                y += 1;
            }
            if (x +1 == n || triangle[y][x+1] != 0) break;
            x += 1;

            // 오른족으로 이동
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 ==n || triangle[y][x+1] != 0) break;
                x += 1;
            }
            if (triangle[y-1][x-1] != 0) break;
            x -= 1;
            y -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y-1][x-1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || triangle[y+1][x] != 0) break;
            y += 1;
        }
        int[] result = new int[v - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }


    /*
    Solution 2 : dx, dy 개념을 사용한 solution
     */
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};


    public int[] solution2(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        prob02 prob02 = new prob02();
        int[] solution1 = prob02.solution(5);
        for (int i : solution1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] solution2 = prob02.solution2(5);
        for (int i : solution2) {
            System.out.print(i + " ");
        }
    }
}
