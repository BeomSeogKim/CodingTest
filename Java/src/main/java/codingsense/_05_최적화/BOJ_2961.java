package codingsense._05_최적화;

import java.util.Scanner;

public class BOJ_2961 {

    static int[][] ingredient;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ingredient = new int[n][2];

        for (int i = 0; i < n; i++) {
            ingredient[i][0] = sc.nextInt();   // 신맛
            ingredient[i][1] = sc.nextInt();   // 쓴맛
        }

        recursion(0, 1, 0, 0);

        System.out.println(min);
    }

    static void recursion(int depth, int sin, int ssen, int use) {
        if (depth == ingredient.length) {
            if (use == 0) {
                return;
            }
            min = Math.min(min, Math.abs(sin - ssen));
            return;
        }

        // 재료 추가
        recursion(depth + 1, sin * ingredient[depth][0], ssen + ingredient[depth][1], use + 1);
        // 재료 추가 X
        recursion(depth + 1, sin, ssen, use);
    }
}
