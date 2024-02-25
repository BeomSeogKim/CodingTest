package codingsense._01_완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            long number = sc.nextLong();
            if (check(number)) {
                list.add("YES");
            } else {
                list.add("NO");
            }
        }

        list.forEach(System.out::println);
    }

    private static boolean check(long number) {
        if (number <= 1000000){
            return false;
        }
        for (int i = 2; i < 1000000; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

