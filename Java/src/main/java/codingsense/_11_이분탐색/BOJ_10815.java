package codingsense._11_이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] card1 = new int[n];
        for (int i = 0; i < n; i++) {
            card1[i] = sc.nextInt();
        }
        Arrays.sort(card1);

        int m = sc.nextInt();
        int[] card2 = new int[m];
        for (int i = 0; i < m; i++) {
            card2[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int p1 = 0;
            int p2 = n - 1;
            int answer = card2[i];
            boolean isMatched = false;
            while (p1 <= p2) {
                int mid = (p1 + p2) / 2;
                if (card1[mid] == answer) {
                    isMatched = true;
                    break;
                } else if (card1[mid] > answer) {
                    p2 = mid - 1;
                } else {
                    p1 = mid + 1;
                }
            }
            if (isMatched) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
