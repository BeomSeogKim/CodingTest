package codingsense._05_최적화;

import java.util.Scanner;

public class BOJ_14501 {

    static int[][] chart;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        chart = new int[n][2];
        for (int i = 0; i < n; i++) {
            chart[i][0] = sc.nextInt();
            chart[i][1] = sc.nextInt();
        }

        recursion(0, 0);

        System.out.println(max);
    }

    private static void recursion(int day, int price) {
        if (day == chart.length) {
            max = Math.max(max, price);
            return;
        }
        if (day > chart.length) {
            return;
        }

        recursion(day + 1, price);
        recursion(day + chart[day][0], price + chart[day][1]);
    }
}
