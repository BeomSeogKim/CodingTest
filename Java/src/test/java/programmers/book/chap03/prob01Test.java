package programmers.book.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
a1x + b1y + c1e = 0
a2x + b2y + c2e = 0
의 해는 다음과 같다.
x = (b1 * c2 - c1 * b2) / (a1 * b1 - b1 * a2)
y = (c1 * a2 - c2 * a1) / (a1 * b1 - b1 * a2)
 */
class prob01Test {

    private static class Point {
        public long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 교차점 구하기
    // 정수값이 아닐 경우 null return
    private Point intersection(long a1, long b1, long c1,
                               long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - c2 * a1) / (a1 * b2 - b1 * a2);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Integer.MAX_VALUE;
        long y = Integer.MAX_VALUE;
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Integer.MIN_VALUE;
        long y = Integer.MIN_VALUE;
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }



    private String[] solution(int[][] lines) {
        // 모든 방정식에 대해서 해를 구하기
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                Point intersection = intersection(lines[i][0], lines[i][1], lines[i][2],
                        lines[j][0], lines[j][1], lines[j][2]);
                if (intersection != null) points.add(intersection);
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        int height = (int) (maximum.y - minimum.y + 1);
        int width = (int) (maximum.x - minimum.x + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        prob01Test prob01Test = new prob01Test();
        int[][] question1 = new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] solution = prob01Test.solution(question1);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
