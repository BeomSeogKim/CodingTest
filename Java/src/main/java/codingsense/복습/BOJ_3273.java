package codingsense.복습;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        int count = 0;
        Arrays.sort(arr);
        int p1 = 0;
        int p2 = n - 1;
        while (p1 < p2) {
            if (arr[p1] + arr[p2] == x) {
                count++;
                p1++;
                p2--;
            } else if (arr[p1] + arr[p2] > x) {
                p2--;
            } else{
                p1++;
            }
        }
        System.out.println(count);
    }
}
