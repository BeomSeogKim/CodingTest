package codingsense._01_완전탐색;

import java.util.Scanner;

public class BOJ_14568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        /*
        남규 : i => 영훈이보다 2개 이상 많은 사탕을 가져야 함
        영훈 : j
        택희 : k => 홀수여서는 안됨.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ( i + j + k == n && i >= j + 2 && k % 2 == 0 && i != 0 && j != 0 && k != 0) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
