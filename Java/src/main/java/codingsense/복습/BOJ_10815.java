package codingsense.복습;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] card1 = new int[N];
        for (int i = 0; i < N; i++){
            card1[i] = sc.nextInt();
        }
        Arrays.sort(card1);

        int M = sc.nextInt();
        int[] card2 = new int[M];
        for (int i = 0; i < M; i++) {
            card2[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int p1 = 0;
            int p2 = N - 1;
            int current = card2[i];
            boolean isContained = false;
            while (p1 <= p2) {
                int mid = (p1 + p2) / 2;
                if (card1[mid] == current) {
                    isContained = true;
                    break;
                }
                if (card1[mid] > current) {
                    p2 = mid - 1;
                } else {
                    p1 = mid + 1;
                }
            }
            if (isContained) {
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }
        System.out.println(sb);
    }
}
