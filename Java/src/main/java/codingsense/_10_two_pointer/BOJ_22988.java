package codingsense._10_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long[] C = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(C);
        long min;
        if (X % 2 == 0) {
            min = X / 2;
        } else {
            min = X / 2 + 1;
        }
        int p1 = 0;
        int p2 = N - 1;

        int answer = 0;
        int res = 0;
        while (p1 <= p2) {
            if (C[p2] == X) {
                answer++;
                p2--;
            } else if (p1 == p2) {
                res++;
                break;
            } else if (C[p1] + C[p2] >= min) {
                answer++;
                p1++;
                p2--;
            } else {
                res++;
                p1++;
            }

        }
        System.out.println(answer + res / 3);
    }
}
