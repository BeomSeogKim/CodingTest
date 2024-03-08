package codingsense._06_기억;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14501 {

    static int N;
    static int[] dp;
    static int[][] table;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        table = new int[N+1][2]; // 상담 기간과 이익을 저장할 배열
        dp = new int[N+1]; // 메모이제이션을 위한 배열

        for (int i = 1; i <= N; i++) {
            table[i][0] = sc.nextInt(); // 상담에 걸리는 기간
            table[i][1] = sc.nextInt(); // 상담을 통해 얻는 이익
        }

        Arrays.fill(dp, -1);

        System.out.println(sol(1));
        sc.close();
    }

    static int sol(int idx) {
        if (idx > N + 1) {
            return Integer.MIN_VALUE;
        }
        if (idx == N + 1) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // 삼항 연산자가 굳이 필요한 것은 아니다. 다만 삼항연산자로 검증을 하게 된다면 불필요한 재귀를 줄일 수 있기 때문에 권장.
//        dp[idx] = Math.max(sol(idx + 1), (idx + table[idx][0] <= N + 1 ? sol(idx + table[idx][0]) + table[idx][1] : Integer.MIN_VALUE));
        dp[idx] = Math.max(sol(idx + 1), sol(idx + table[idx][0]) + table[idx][1]);
        return dp[idx];
    }
}
