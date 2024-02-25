package codingsense._01_완전탐색;

import java.util.Scanner;

public class BOJ_19532 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] index = new int[6];
        for (int i = 0; i < 6; i++) {
            index[i] = sc.nextInt();
        }

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (
                    (index[0] * x) + (index[1] * y) == index[2] &&
                        (index[3] * x) + (index[4] * y) == index[5]) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }

}
