package codingsense._05_최적화;

import java.util.Scanner;

public class BOJ_19942 {
    static int N;
    static int mp, mf, ms, mv;  // 최소 단백질, 지방, 탄수화물, 비타민
    static int[][] ingredients;
    static int[] selected;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mp = sc.nextInt();
        mf = sc.nextInt();
        ms = sc.nextInt();
        mv = sc.nextInt();

        ingredients = new int[N][5];
        selected = new int[N];
        for (int i = 0; i < N; i++) {
            ingredients[i][0] = sc.nextInt();
            ingredients[i][1] = sc.nextInt();
            ingredients[i][2] = sc.nextInt();
            ingredients[i][3] = sc.nextInt();
            ingredients[i][4] = sc.nextInt();
        }

        recursion(0, 0, 0, 0, 0, 0, selected);

        System.out.println(min);
        System.out.println(sb);
    }

    private static void recursion(int depth, int p, int f, int s, int v, int price, int[] selected) {
        if (depth == N) {
            if (p >= mp && f >= mf && s >= ms && v >= mv) {
                min = Math.min(min, price);
                sb = new StringBuilder();
                for (int i : selected){
                    sb.append(i).append(" ");
                }
            }
            return;
        }
        recursion(depth + 1, p, f, s, v, price, selected);
        selected[depth] = depth;
        recursion(depth + 1, p + ingredients[depth][0], f + ingredients[depth][1], s + ingredients[depth][2],
            v + ingredients[depth][3], price + ingredients[depth][4], selected);
    }
}
